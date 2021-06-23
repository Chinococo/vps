package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class simple_cilenet extends WebSocketClient {
    Timer timer1 = new Timer();
    Timer timer2 = new Timer();

    public simple_cilenet(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public simple_cilenet(URI serverURI) {
        super(serverURI);
    }

    public simple_cilenet(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

        System.out.println("opened connection");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
              sendPing();
              System.out.println("ping "+new Date());
            }
        },3000,3000);

        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                reconnect();
                System.out.println("reconnect "+new Date());
            }
        },30000,30000);




    }

    @Override
    public void reconnect() {
        super.reconnect();
        timer1.cancel();
        timer2.cancel();
        timer1=new Timer();
        timer2=new Timer();
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // The codecodes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println(
                "Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
                        + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }
}
