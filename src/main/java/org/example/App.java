package org.example;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public final String apikey="HsOeWp8YyePa0w0jSZEMsmdvM65E9wyyExU1m4CTNmRedNUrYV186kG561LmviIg";
    public final String secretkey="D9r4okfmxpufNrGJ0EjdUQF3g9VQ02lgUsZwM6hhOZahb9NZogB7EDNJhkb6yXhj";

    public static void main(String[] args) throws IOException {
        System.out.println(new function().get_timestamp());
        System.out.println(new function().sha256_HMAC_signture("symbol=LTCBTC&side=BUY&type=LIMIT&timeInForce=GTC&quantity=1&price=0.1&recvWindow=5000&timestamp=1499827319559","NhqPtmdSJYdKjVHjA7PZj4Mge3R5YNiP1e3UZjInClVN65XAbvqqM6A7H5fATj0j"));

    }


}
