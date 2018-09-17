package com.example.sungs.smoothyrtc.Message.SendMessage;

import com.example.sungs.smoothyrtc.Message.ReceivingMessage.ReceivingMessage;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class AnswerMessage implements SendingMessage,ReceivingMessage {

    public static final String TAG="AnswerMessage.class";

    String fromUserID;
    String toUserID;
    String answer;
    String type;


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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toJson() {

        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<AnswerMessage> jsonAdapter = moshi.adapter(AnswerMessage.class);

        String json = jsonAdapter.toJson(AnswerMessage.this);

        return json;
    }

    @Override
    public void fromJson(String json) {

    }
}
