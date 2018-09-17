package com.example.sungs.smoothyrtc.Message.SendMessage;

import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ReceivingMessage;

public class OfferMessage implements SendingMessage,ReceivingMessage {

    String toUserID;
    String fromUSerID;
    String offer;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    public String getFromUSerID() {
        return fromUSerID;
    }

    public void setFromUSerID(String fromUSerID) {
        this.fromUSerID = fromUSerID;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }


    @Override
    public String toJson() {
        return null;
    }

    @Override
    public void fromJson(String json) {

    }
}
