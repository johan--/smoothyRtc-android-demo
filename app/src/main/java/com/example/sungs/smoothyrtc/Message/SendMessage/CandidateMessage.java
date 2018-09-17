package com.example.sungs.smoothyrtc.Message.SendMessage;

import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ReceivingMessage;

public class CandidateMessage implements SendingMessage,ReceivingMessage {

    final static String TAG ="CadidateMeassage.class";

    String fromUserID;
    String toUserID;
    String candidate;
    String type;

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

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toJson() {
        return null;
    }

    @Override
    public void fromJson(String json) {

    }
}
