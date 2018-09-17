package com.example.sungs.smoothyrtc.Model;

public class SignalingRoom {

    String roomID;
    String[] users;

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }
}
