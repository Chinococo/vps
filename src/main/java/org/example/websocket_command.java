package org.example;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class websocket_command {
    String method=null;
    ArrayList<Object> params=null;
    int id=-1;
    websocket_command( String method,ArrayList<Object> params,int id)
    {
        if(method!=null)
            this.method=method;
        if(params!=null)
            this.params=params;
        if(id!=-1)
            this.id=id;
    }

    String build()
    {
        HashMap<String,Object> test = new HashMap<>();
        test.put("method",method);
        test.put("params",params);
        test.put("id",id);
        return new JSONObject(test).toString();
    }
}
