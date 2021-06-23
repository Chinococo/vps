package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;

public class simple_cilenet extends WebSocketClient {
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
        /*
        send("{\n" +
                "\"method\": \"SUBSCRIBE\",\n" +
                "\"params\":\n" +
                "[\n" +
                "\"btcusdt@aggTrade\",\n" +
                "\"btcusdt@depth\"\n" +
                "],\n" +
                "\"id\": 1\n" +
                "}");

         */
        System.out.println("opened connection");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
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