package org.example;


import com.google.gson.Gson;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class function {

    /*
    製造簽名
    message = 加密訊息=傳送出去的參數
    secret = 密鑰
     */
    public String sha256_HMAC_signture(String message, String secret)
    {
        String hash = "";
        try {
            byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8.name()); // 把密鑰字串轉為byte[]
            Key hmacKey = new SecretKeySpec(keyBytes, "HmacSHA256"); // 建立HMAC加密用密鑰
            Mac hmacSHA256 = Mac.getInstance("HmacSHA256"); // 取得SHA256 HMAC的Mac實例
            hmacSHA256.init(hmacKey); // 使用密鑰對Mac進行初始化
            byte[] macData = hmacSHA256.doFinal(message.getBytes(StandardCharsets.UTF_8.name())); // 對原始訊息進行雜湊計算
            String hexStringOfTheOriginMessage = Hex.encodeHexString(macData); //  使用Apache Commons Codec的Hex把雜湊計算的結果轉為Hex字串
            return hexStringOfTheOriginMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "none";
    }
    /*
    取得時間戳記
     */

    public String get_timestamp()
    {
        http_service http_service = new http_service("https://api.binance.com/api/v1/time","GET");
        timestamp t  = new Gson().fromJson(http_service.sync_GET(),timestamp.class);
        return t.serverTime;
    }

    /*
    取得交易訊息
     */
    public String get_exchangeinfo()
    {
        String url = "https://api.binance.com/api/v3/exchangeInfo";
        return new http_service(url,"GET").sync_GET();
    }

    /*
    取得最近交易紀錄
    Symol = 種類
    limit = 回傳項目上限
     */
    public String get_recent_trades(String symbol,int limit)
    {
        ArrayList<NameValuePair> pram = new ArrayList<>();
        pram.add(new BasicNameValuePair("symbol",symbol));
        pram.add(new BasicNameValuePair("limit",limit+""));
        String url = "https://api.binance.com/api/v3/trades";
        return new http_service(url,"GET",pram).sync_GET();

    }

    /*
    取得k線
    Symol = 種類
    interval = 時間間隔
    StartTime = 開始時間
    endTime = 結束時間
    limit = 回傳項目上限
     */
    public String get_kline(String symbol,String interval,long startTime,long endTime,int limit)
    {
        ArrayList<NameValuePair> pram = new ArrayList<>();
        pram.add(new BasicNameValuePair("symbol",symbol));
        pram.add(new BasicNameValuePair("interval",interval+""));
        //pram.add(new BasicNameValuePair("symbol",startTime+""));
        //pram.add(new BasicNameValuePair("endTime",endTime+""));
        pram.add(new BasicNameValuePair("limit",limit+""));
        String url = "https://api.binance.com/api/v3/klines";
        return new http_service(url,"GET",pram).sync_GET();

    }
    /*
    取得現在價格
    */
    public String get_price()
    {
        String url = "https://api.binance.com/api/v1/ticker/price";
        return new http_service(url,"GET").sync_GET();
    }


    class timestamp
    {
        String serverTime;
    }

}
