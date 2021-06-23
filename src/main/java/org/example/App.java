package org.example;

import com.alibaba.fastjson.JSONObject;
import jakarta.websocket.ClientEndpoint;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.server.WebSocketServer;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.ObjectUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        ArrayList<Object> test = new ArrayList<>();


        //System.out.println();


        simple_cilenet c = new simple_cilenet(new URI("wss://stream.binance.com:9443/ws/btcusdt@Trade")); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        c.connect();
        websocket_command cmd ;


        Thread.sleep(1000);
        test.add("btcusdt@Trade");
        cmd = new websocket_command("UNSUBSCRIBE",test,1);
        c.send(cmd.build());

        //Thread.sleep(1000);
        cmd = new websocket_command("LIST_SUBSCRIPTIONS",null,1);
        c.send(cmd.build());


        //Thread.sleep(1000);
        cmd = new websocket_command("SUBSCRIBE",test,1);
        c.send(cmd.build());

        //Thread.sleep(1000);
        cmd = new websocket_command("LIST_SUBSCRIPTIONS",null,1);
        c.send(cmd.build());




























        //ok//System.out.println(function.get_listenkey());
        //System.out.println(function.get_timestamp());
        //OK//System.out.println(function.sha256_HMAC_signture("symbol=LTCBTC&side=BUY&type=LIMIT&timeInForce=GTC&quantity=1&price=0.1&recvWindow=5000&timestamp=1499827319559","NhqPtmdSJYdKjVHjA7PZj4Mge3R5YNiP1e3UZjInClVN65XAbvqqM6A7H5fATj0j"));
        //OK//System.out.println(function.get_exchangeinfo());
        //OK//System.out.println(function.get_recent_trades("LTCBTC",1));
        //OK//System.out.println(unction.get_kline("LTCBTC","1m",0,0,10));
        //OK//System.out.println(function.get_price());

        //OK//test_order
        /*
        ArrayList<NameValuePair> pram = new ArrayList<>();
        pram.add(new BasicNameValuePair("symbol", "BTCUSDT"));
        pram.add(new BasicNameValuePair("side", "SELL"));
        pram.add(new BasicNameValuePair("type", "LIMIT"));
        pram.add(new BasicNameValuePair("quantity", "0.001"));
        pram.add(new BasicNameValuePair("timeInForce", "GTC"));
        pram.add(new BasicNameValuePair("price", "90000"));
        //pram.add(new BasicNameValuePair("quoteOrderQty","none"));
        //pram.add(new BasicNameValuePair("newClientOrderId","none"));
        //pram.add(new BasicNameValuePair("stopPrice","none"));
        //pram.add(new BasicNameValuePair("icebergQty","none"));
        //pram.add(new BasicNameValuePair("newOrderRespType","none"));
        //pram.add(new BasicNameValuePair("recvWindow","none"));
        String time = function.get_timestamp();
        pram.add(new BasicNameValuePair("timestamp", time));
        pram.add(new BasicNameValuePair("signature", function.sha256_HMAC_signture(build_signature_post_pram(pram), R.account.secretkey)));
        System.out.println(function.test_order_api(pram));

         */




    }
    static String build_signature_post_pram(ArrayList<NameValuePair> pram) {
        String sb = "";
        if (pram == null)
            return sb;
        for (int i = 0; i < pram.size(); i++) {
            if (i == 0) {
                sb += (pram.get(i).getName() + "=" + pram.get(i).getValue());
            } else {
                sb += ("&" + pram.get(i).getName() + "=" + pram.get(i).getValue());
            }
        }
        return sb;
    }

}
