package org.example;


import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class http_service {
    private String get_respond = null, url = null, melthod = null;
    private CloseableHttpClient cilent = null;
    private HttpEntity entity = null;
    private List<NameValuePair> pram = new ArrayList<>();
    private String decoder = "UTF-8";
    private String e = "ERROR";
    private final String sync_able = "sync";
    private HashMap<String, String> header = new HashMap<>();

    public http_service(String url, String melthod, ArrayList<NameValuePair> pram, String decoder, HashMap<String, String> header) {
        this.url = url;
        this.melthod = melthod;
        this.pram = pram;
        this.decoder = decoder;
        this.header = header;
    }

    public http_service(String url, String melthod, ArrayList<NameValuePair> pram, String decoder) {
        this.url = url;
        this.melthod = melthod;
        this.pram = pram;
        this.decoder = decoder;
    }

    public http_service(String url, String melthod, List<NameValuePair> pram) {
        this.url = url;
        this.melthod = melthod;
        this.pram = pram;
    }

    public http_service(String url, String melthod) {
        this.url = url;
        this.melthod = melthod;
    }

    private void build_GET_pram() {
        System.out.println(pram.toString());
        if (pram.size() == 0)
            return;
        url = url + "?" + pram.get(0).getName() + "=" + pram.get(0).getValue();
        for (int i = 1; i < pram.size(); i++)
            url = url + "&" + pram.get(i).getName() + "=" + pram.get(i).getValue();
        System.out.println(url);
    }

    public String sync_GET()//同步請求GET指令
    {
        System.out.println("connect with url :" +url);
        System.out.println("melthos by GET");
        try {
            build_GET_pram();
            System.out.println("create pram to url :"+url);
            HttpUriRequest request = new HttpGet(url);
            for (String key : header.keySet())
                request.setHeader(key, header.get(key));
            cilent = HttpClientBuilder
                    .create()
                    .build();
            CloseableHttpResponse response = cilent.execute(request);
            System.out.println("status code="+response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                entity = response.getEntity();
                if (entity != null) {
                    get_respond = EntityUtils.toString(entity, decoder);
                    return get_respond;
                } else {
                    get_respond = e;
                    return get_respond;
                }

            } else {
                get_respond = response.toString();
                return get_respond;
            }
        } catch (Exception e) {
            e.printStackTrace();
            get_respond = this.e;
            return get_respond;
        }

    }

    public String sync_POST() {
        BufferedReader in = null;
        try {
            cilent = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            for (String key : header.keySet())
                httpPost.setHeader(key, header.get(key));
            httpPost.setEntity(new UrlEncodedFormEntity(pram, HTTP.UTF_8));
            CloseableHttpResponse response = cilent.execute(httpPost);
            int state = response.getStatusLine().getStatusCode();
            if (state == HttpStatus.SC_OK) {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                return sb.toString();
            } else {
                System.out.println("POST請求狀態碼：" + state);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
