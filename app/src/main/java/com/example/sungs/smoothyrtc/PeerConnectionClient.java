package com.example.sungs.smoothyrtc;

import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SessionDescription;
import org.webrtc.StatsReport;

public class PeerConnectionClient {

    private PeerConnection peerConnection;
    private PeerConnectionFactory factory;

    public interface PeerConnectionEvents {

        void onLocalDescription(final SessionDescription sdp);

        void onIceCandidate(final IceCandidate candidate);

        void onIceCandidatesRemoved(final IceCandidate[] candidates);

        void onIceConnected();

        void onIceDisconnected();

        void onPeerConnectionClosed();

        void onPeerConnectionStatsReady(final StatsReport[] reports);

        void onPeerConnectionError(final String description);
    }

    static public PeerConnectionClient CreatePeerConnectionClient(){

        PeerConnectionClient peerConnectionClinet = new PeerConnectionClient();

        return  peerConnectionClinet;
    }

    public PeerConnectionClient(){

    }

    void createPeerConnection(){

    }


    public void createOffer(){


    }

    public void createAnswer(){


    }

    private static void jsonPut(JSONObject json, String key, Object value) {
        try {

            json.put(key, value);

        } catch (JSONException e) {

            throw new RuntimeException(e);
        }
    }
}
