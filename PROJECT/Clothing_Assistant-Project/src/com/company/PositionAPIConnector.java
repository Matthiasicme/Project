package com.company;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PositionAPIConnector {
    private static String API_URL = "api.openweathermap.org/data/2.5/weather?lat=22&lon=55&limit=1&appid=6d3be0cf8606812a5623b693d6b9197e ";


    public JSONObject getData(String Location) throws IOException {

        RESTAPIConnector restapiConnector = new RESTAPIConnector();
        return RESTAPIConnector.getData(API_URL+ Location +"&appid={ID}&units=metric");
    }
}
