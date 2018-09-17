package com.example.sungs.smoothyrtc.Message.ReceivingMessage;

import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class ErrMessage implements ReceivingMessage {

    private String TAG="ErrMessage";

    private String type;
    private String message;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void setfromAnother(ErrMessage message){

        this.setType(message.getType());
        this.setMessage(message.getMessage());

    }

    @Override
    public void fromJson(String json) {
        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<ErrMessage> jsonAdapter = moshi.adapter(ErrMessage.class);

        try{
           ErrMessage message= jsonAdapter.fromJson(json);
            setfromAnother(message);
        }catch (IOException e){
            Log.e(TAG,e.toString());
        }
    }
}
