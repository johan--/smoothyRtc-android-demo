package com.example.sungs.smoothyrtc.Message;

import android.util.Log;

import com.example.sungs.smoothyrtc.Exception.SmoothyRtcException;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ErrMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.AnswerMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.OfferMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.SendingMessage;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.EnterResponse;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.LoginResponse;
import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ReceivingMessage;
import com.squareup.moshi.Json;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageParser {

    public static final String TAG ="MessageParser.class";

    public ReceivingMessage fromJson(String messageJson) {

        String messageType = getMessageType(messageJson);

        ReceivingMessage message = null;


        switch (messageType) {
            case Constants.SESSION_MESSAGE.LOGIN:

                message = new LoginResponse();

                message.fromJson(messageJson);

                break;
            case Constants.ROOM_MESSANGE.ENTER_ROOM:

                message = new EnterResponse();

                message.fromJson(messageJson);

                break;
            case Constants.NEGOTIATION_MEASSAGE.OFFER:

                message = new OfferMessage();

                break;
            case Constants.NEGOTIATION_MEASSAGE.ANSWER:

                message = new AnswerMessage();

                break;

        }

        return message;

    }

    public String toJson(SendingMessage message){

        return message.toJson();

    }

    public String getMessageType(String messageJson)  {

        String type =null;

        try{
                JSONObject jsonObject = new JSONObject(messageJson);
                type = jsonObject.getString("type");

            }catch (JSONException e){
                Log.e(TAG,e.toString());
            }

        return type;
    }

    public boolean isErrMessage(String json) throws SmoothyRtcException{

        boolean isErrMessage=false;

        try{
            JSONObject jobject = new JSONObject(json);
            if(jobject.getString("type").startsWith("err:")){
                isErrMessage = true;
            }

        }catch (JSONException e){
            Log.e(TAG,"err:" + e.toString());
            throw new SmoothyRtcException(e.toString());
        }

        return isErrMessage;

    }
}
