package com.example.sungs.smoothyrtc.Message.ReceivingMessage;

import android.util.Log;

import com.example.sungs.smoothyrtc.Model.SignalingRoom;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class EnterResponse implements ReceivingMessage {

    static final String TAG ="EnterResponse.class";

    private String type;
    private Boolean success;
    private SignalingRoom room;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    void setEnterResponse(EnterResponse another){

        setType(another.getType());
        setSuccess(another.getSuccess());
        setRoom(another.getRoom());

    }


    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SignalingRoom getRoom() {
        return room;
    }

    public void setRoom(SignalingRoom room) {
        this.room = room;
    }

    @Override
    public void fromJson(String json)  {

        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<EnterResponse> jsonAdapter = moshi.adapter(EnterResponse.class);

        try{
            EnterResponse message= jsonAdapter.fromJson(json);
            setEnterResponse(message);
        }catch (IOException e){
            Log.e(TAG,e.toString());
        }

    }
}
