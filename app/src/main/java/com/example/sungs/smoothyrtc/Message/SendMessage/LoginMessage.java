package com.example.sungs.smoothyrtc.Message.SendMessage;

import com.example.sungs.smoothyrtc.Message.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class LoginMessage implements SendingMessage {

    static String TAG ="LoginMessssage.class";

    private String fromUserID;
    String type;

    public LoginMessage(String fromUserID){
        this.fromUserID = fromUserID;
        this.type = Constants.SESSION_MESSAGE.LOGIN;
    }

    public LoginMessage(){

    }

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

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<LoginMessage> jsonAdapter = moshi.adapter(LoginMessage.class);

        String json = jsonAdapter.toJson(LoginMessage.this);

        return json;
    }


}
