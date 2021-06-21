package org.example;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
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
