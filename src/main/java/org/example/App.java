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
        hmac_sha256 hmac_sha256 = new hmac_sha256();
        System.out.println(new function().sha256_HMAC_signture("symbol=LTCBTC&side=BUY&type=LIMIT&timeInForce=GTC&quantity=1&price=0.1&recvWindow=5000&timestamp=1499827319559","NhqPtmdSJYdKjVHjA7PZj4Mge3R5YNiP1e3UZjInClVN65XAbvqqM6A7H5fATj0j"));

        /*
        List<NameValuePair> data = new ArrayList<>();
        data.add(0, new BasicNameValuePair("Content-Type", "application/json"));
        data.add(1, new BasicNameValuePair("test", "test"));
        final http_service http_service =
                new http_service(
                        "https://script.googleusercontent.com/macros/echo?user_content_key=u9-JsBDhUGuJ9Pi2-Eq8JdVw5wOilB7HsYBjITRxfS5oqFfbmH7GEWxASxlyu2skHFEDHsTTiDp6Dv2gVB_aotAegYehKzbEm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnGECNUmXxjhedQ_htoevUS3fhfGhJZTm26haPtqsbbktnBakjDwm7xAs_q7FUzNqYsRj_hZU7e1eL0rwJSBi7syrng45fcOZeA&amp;lib=M-WZcEolqTllL0Ywphi90jUg5wj_dILIK"
                        , "GET"
                        , data);
        System.out.println(http_service.sync_POST());
        System.out.println("End"); */
    }


}
