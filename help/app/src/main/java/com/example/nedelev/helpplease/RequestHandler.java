package com.example.nedelev.helpplease;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.parse.ParseObject;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nedelev on 18.11.2016 г..
 */
public class RequestHandler implements Serializable {


    private ParseObject parseObject;

    public RequestHandler(ParseObject o){
        parseObject = o;
    }

    public void put(String column, Object value){
        parseObject.put(column, value);
        parseObject.saveInBackground();
    }
}
