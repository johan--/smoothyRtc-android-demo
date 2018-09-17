package com.example.sungs.smoothyrtc;

import android.util.Log;

import com.example.sungs.smoothyrtc.Message.Constants;
import com.example.sungs.smoothyrtc.Message.MessageParser;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;

import java.io.IOException;
import java.net.URI;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketConnection  {

    static String TAG ="webSocketConnection";

    OkHttpClient okHttpClient;
    WebSocketListener webSocketListener;
    WebSocket ws;

    public enum State {
        CLOSED, CLOSING, CONNECT_ERROR, RECONNECT_ATTEMPT, RECONNECTING, OPENING, OPEN
    }

    class OKWebSocketListener extends WebSocketListener{


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
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);

            Log.d(TAG,"webSocket onMessage");
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);

            Log.d(TAG,"WebSocket onFailure \n e:" +t);
        }

    }


    public WebSocket start(){

        okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(BuildConfig.WEBSOCKET_SERVER_URL).build();
        OKWebSocketListener listener = new OKWebSocketListener();
        ws = okHttpClient.newWebSocket(request, listener);

        okHttpClient.dispatcher().executorService().shutdown();

        return ws;


    }



}
