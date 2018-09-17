package com.example.sungs.smoothyrtc.Message.ReceivingMessage;

import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class LoginResponse implements ReceivingMessage {

    static final String TAG ="LoginResponse.class";

//    static final int ERR_SESSION=0;
//    static final int ERR_DUBLICATE_USERID =1;

    String type;
    Boolean success;
//    int errCode;

    public void setLoginResponse(LoginResponse loginResponse){

        setType(loginResponse.getType());
        setSuccess(loginResponse.getSuccess());

    }

    public LoginResponse(){

    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

//    public int getErrCode() {
//        return errCode;
//    }
//
//    public void setErrCode(int errCode) {
//        this.errCode = errCode;
//    }

    @Override
    public void fromJson(String json)  {

        Moshi moshi = new Moshi.Builder().build();

        JsonAdapter<LoginResponse> jsonAdapter = moshi.adapter(LoginResponse.class);


        try{
            LoginResponse message =jsonAdapter.fromJson(json);
            setLoginResponse(message);

        }catch (IOException e){
            Log.e(TAG,e.toString());

        }



    }


}
