package com.example.sungs.smoothyrtc.Message;

public class Constants {

    public interface NEGOTIATION_MEASSAGE{

        public final static String OFFER ="negotiation:offer";
        public final static String ANSWER ="negotiation:answer";

    }

    public interface SESSION_MESSAGE{

        public final static String LOGIN ="session:login";
        public final static String LOGOUT="session:logout";
        public final static String DISCONNECTED ="session:disconnected";
    }

    public interface BROADCASTMESSAGE {
        public final static String ENTER_ROOM="broadcast:enterRoom";
        public final static String LEAVE_ROOM="broadcast:leaveRoom";
    }

    public interface NEGOTIATION_MESSAGE {
        public final static String OFFER="negotiation:offer";
        public final static String ANSWER="negotiation:answer";
        public final static String CANDIDATE="negotiation:candidate";
        public final static String SUCESS_NEGOTIATION="negotiation:sucess";
        public final static String  FAILED_NEGOTIATION="negotiation:failed";
    }

    public interface ROOM_MESSANGE{
        public final static String ENTER_ROOM="room:enterRoom";
        public final static String FAILED_ENTER_ROOM="room:failedEnterRoom";
        public final static String LEAVE_ROOM="room:leaveRoom";
    }

    public interface ERR_MESSAGE{

        public final static String EINVALIDMESSAGE= "err:invalidMessage";

    }




}
