package org.example;


import com.google.gson.Gson;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class function {
    public String sha256_HMAC_signture(String message, String secret) {
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
    public String get_timestamp()
    {
        http_service http_service = new http_service("https://api.binance.com/api/v1/time","GET");
        timestamp t  = new Gson().fromJson(http_service.sync_GET(),timestamp.class);
        return t.serverTime;
    }
    class timestamp
    {
        String serverTime;
    }
}
