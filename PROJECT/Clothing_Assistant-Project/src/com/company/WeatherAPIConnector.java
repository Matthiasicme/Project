package com.company;
import org.json.JSONObject;
import java.io.IOException;


public class WeatherAPIConnector {
    private static String API_URL = "http://api.openweathermap.org/geo/1.0/direct?q=";


    public JSONObject getData(String Location) throws IOException {

         RESTAPIConnector restapiConnector = new RESTAPIConnector();
        return restapiConnector.getData(API_URL+ Location +"&appid=6d3be0cf8606812a5623b693d6b9197e&units=metric");
    }
}
