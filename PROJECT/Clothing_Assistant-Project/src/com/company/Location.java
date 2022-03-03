package com.company;
import org.json.JSONObject;

import java.io.IOException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Location {
    public String name;
    public double latitude;
    public double longitude;

    public Location(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public JSONObject getJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name);
        jsonObject.put("latitude", this.latitude);
        jsonObject.put("longitude", this.longitude);
        return jsonObject;
    }

}
