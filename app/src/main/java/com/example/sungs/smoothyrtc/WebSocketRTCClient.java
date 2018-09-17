package com.example.sungs.smoothyrtc;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.example.sungs.smoothyrtc.Exception.SmoothyRtcException;
import com.example.sungs.smoothyrtc.Message.Constants;
import com.example.sungs.smoothyrtc.Message.Listener.MessageListener;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ErrMessage;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.LeaveRoomRecive;
import com.example.sungs.smoothyrtc.Message.SendMessage.AnswerMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.CandidateMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.EnterRoomMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.LeaveRoomMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.LoginMessage;
import com.example.sungs.smoothyrtc.Message.MessageParser;

import com.example.sungs.smoothyrtc.Message.SendMessage.OfferMessage;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.EnterResponse;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.LoginResponse;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ReceivingMessage;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketRTCClient extends WebSocketListener {

    private static final int CLOSE_TIMEOUT = 1000;

    static final String TAG ="WebSocketRtcClient";

    OkHttpClient okHttpClient;
    WebSocket webSocket;

    HandlerThread handlerThread;
    Handler handler;

    MessageListener messageListener;
    MessageParser parser;

    String userID;

    WebSocketRTCClient(String userID , MessageListener messageListener){
        this.userID = userID;
        this.messageListener = messageListener;
        this.parser = new MessageParser();

        handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());

    }

    void connect(){

        okHttpClient =new OkHttpClient.Builder()
                        .readTimeout(CLOSE_TIMEOUT, TimeUnit.MILLISECONDS)
                        .build();

        if(webSocket==null){

            Request request = new Request.Builder().url(BuildConfig.WEBSOCKET_SERVER_URL).build();

            webSocket = okHttpClient.newWebSocket(request, this);

        }

        okHttpClient.dispatcher().executorService().shutdown();

    }

    public void login(LoginMessage message){

        Log.d(TAG,"login with message");
        String messageJson =parser.toJson(message);
        webSocket.send(messageJson);

    }

    public void enterRoom(EnterRoomMessage enterMessage){
        Log.d(TAG, "enter");

        String messageJson = parser.toJson(enterMessage);
        webSocket.send(messageJson);

    }

    public void leaveRoom(LeaveRoomMessage message){

        Log.d(TAG,"leaveRoom");

        String messageJson = parser.toJson(message);
        webSocket.send(messageJson);

    }

    public void sendOffer(OfferMessage message){

        String messageJson =parser.toJson(message);

        webSocket.send(messageJson);

    }

    public void sendAnswer(AnswerMessage message){

        String messageJson = parser.toJson(message);

        webSocket.send(messageJson);
    }

    public void sendCandidate(CandidateMessage message){

        String messageJson = parser.toJson(message);

        webSocket.send(messageJson);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);

        Log.d(TAG,"webSocket onOpen");
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);

        Log.d(TAG,"webSocket onClosed");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text)  {
        super.onMessage(webSocket, text);

        Log.d(TAG,"webSocket onMessage");

        try{
            if(parser.isErrMessage(text)){

                ErrMessage errMessage = new ErrMessage();

                errMessage.fromJson(text);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        messageListener.onMessageFailed(new SmoothyRtcException( errMessage.getMessage()));
                    }
                });



            }
        }catch (SmoothyRtcException e){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    messageListener.onMessageFailed(e);
                }
            });

        }

        ReceivingMessage message = parser.fromJson(text);

        String type =message.getType();

        switch (type){
            case Constants.SESSION_MESSAGE.LOGIN:

                LoginResponse loginResponse =(LoginResponse) message;

                if(loginResponse.getSuccess()){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            messageListener.onLoginSuccess();
                        }
                    });
                }
                else{

                }
                break;
            case Constants.ROOM_MESSANGE.ENTER_ROOM:

                EnterResponse enterResponse =(EnterResponse)message;
                if(enterResponse.getSuccess()){

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            messageListener.onEnterRoomSuccess();
                        }
                    });

                }else{

                    //todo handle failed createRoom
                }
                break;

            case Constants.ROOM_MESSANGE.LEAVE_ROOM:

                LeaveRoomRecive leaveRoomRecive =(LeaveRoomRecive) message;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            messageListener.onLeaveRoomSuccess();
                        }
                    });


                break;
            default:
                //todo err handle
                break;
        }

    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);

        Log.d(TAG,"WebSocket onFailure \n e:" +t);

        handler.post(new Runnable() {
            @Override
            public void run() {
                messageListener.onMessageFailed(new SmoothyRtcException(t.getMessage()));
            }
        });
    }




}
