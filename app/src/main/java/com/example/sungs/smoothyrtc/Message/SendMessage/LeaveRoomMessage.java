package com.example.sungs.smoothyrtc.Message.SendMessage;

import com.example.sungs.smoothyrtc.Message.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class LeaveRoomMessage implements SendingMessage {

    String type;
    String roomID;
    String fromUserID;

    public LeaveRoomMessage(String roomID, String fromUserID) {
        this.type = "test";
        this.roomID = roomID;
        this.fromUserID = fromUserID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<LeaveRoomMessage> jsonAdapter = moshi.adapter(LeaveRoomMessage.class);

        String json = jsonAdapter.toJson(LeaveRoomMessage.this);

        return json;
    }
}
