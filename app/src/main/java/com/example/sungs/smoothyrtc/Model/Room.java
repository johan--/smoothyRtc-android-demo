package com.example.sungs.smoothyrtc.Model;

import android.content.Context;

import com.example.sungs.smoothyrtc.ConnectOptions;
import com.example.sungs.smoothyrtc.Exception.SmoothyRtcException;
import com.example.sungs.smoothyrtc.WebSocketRTCClient;

import java.util.HashMap;
import java.util.List;

public class Room {

    String roomID;
    LocalParticipant localParticipant;
    List<RemoteParticipant> remoteParticipant;   //list?? map??
    String state;

    private WebSocketRTCClient webSocketRtcClient;
    private Context context;

    public interface Listener{

        public void onConnected(Room room);

        public void onConnectFailure(Room room, SmoothyRtcException e);

        public void onDisconnected(Room room, SmoothyRtcException e);

        public void onParticipantConnected(Room room, RemoteParticipant participant);

        public void onParticipantDisconnected(Room room, RemoteParticipant participant);

    }

    public void disconnected(){

    }
}
