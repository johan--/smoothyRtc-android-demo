package com.example.sungs.smoothyrtc.Message.Listener;

public interface MessageListener {

    void onLoginSuccess();
    void onEnterRoomSuccess();
    void onLeaveRoomSuccess();

    void onMessageFailed(Exception e);

}
