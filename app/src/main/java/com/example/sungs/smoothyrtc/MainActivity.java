package com.example.sungs.smoothyrtc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sungs.smoothyrtc.Message.Listener.MessageListener;
import com.example.sungs.smoothyrtc.Message.SendMessage.EnterRoomMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.LeaveRoomMessage;
import com.example.sungs.smoothyrtc.Message.SendMessage.LoginMessage;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    Button createBtn;
    Button enterBtn;
    Button leaveBtn;
    Button negotiationBtn;
    WebSocketRTCClient webSocketRTCClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button)findViewById(R.id.btnLoginTest);
        createBtn =(Button)findViewById(R.id.btnCreateTest);
        enterBtn =(Button) findViewById(R.id.btnEnterTest);
        leaveBtn =(Button) findViewById(R.id.btnLeaveTest);
        negotiationBtn =(Button)findViewById(R.id.btnNegotiation);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testLogin();
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testCreate();
            }
        });

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testEnter();
            }
        });

        leaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testLeaveRoom();
            }
        });

        negotiationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testNegotiation();
            }
        });

    }

    public void testLogin(){
        webSocketRTCClient = new WebSocketRTCClient("nss", new MessageListener() {
            @Override
            public void onLoginSuccess() {
                Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onEnterRoomSuccess() {

                Toast.makeText(MainActivity.this, "enter success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLeaveRoomSuccess() {
                Toast.makeText(MainActivity.this, "leaveRoom success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMessageFailed(Exception e) {

                Toast.makeText(MainActivity.this, "messageListen err:" +e.toString(), Toast.LENGTH_LONG).show();

            }
        });

        webSocketRTCClient.connect();

        LoginMessage loginMessage = new LoginMessage("nss");

        webSocketRTCClient.login(loginMessage);

    }

    public void testCreate(){

        EnterRoomMessage enterMessage = new EnterRoomMessage("test","nss");

        webSocketRTCClient.enterRoom(enterMessage);


    }

    public void testEnter(){

        EnterRoomMessage enterMessage = new EnterRoomMessage("test","nss1");

        webSocketRTCClient.enterRoom(enterMessage);

    }

    public void testLeaveRoom(){

        LeaveRoomMessage leaveRoomMessage = new LeaveRoomMessage("test","nss");

        webSocketRTCClient.leaveRoom(leaveRoomMessage);
    }

    public void testNegotiation(){

        //todo negotiation test
    }
}
