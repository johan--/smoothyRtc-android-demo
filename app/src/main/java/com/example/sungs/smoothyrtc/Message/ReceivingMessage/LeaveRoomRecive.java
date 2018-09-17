package com.example.sungs.smoothyrtc.Message.ReceivingMessage;

import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class LeaveRoomRecive implements ReceivingMessage {

     private static final String TAG ="LeaveRoomReceive";

    private String type;
    private String fromUserID;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    private void setLeaveReceive(LeaveRoomRecive another){
        this.setType(another.getType());
        this.setType(another.getFromUserID());
    }

    @Override
    public void fromJson(String json) {

        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<LeaveRoomRecive> jsonAdapter = moshi.adapter(LeaveRoomRecive.class);

        try{
            LeaveRoomRecive message= jsonAdapter.fromJson(json);
            setLeaveReceive(message);
        }catch (IOException e){
            Log.e(TAG,e.toString());
        }
    }
}
