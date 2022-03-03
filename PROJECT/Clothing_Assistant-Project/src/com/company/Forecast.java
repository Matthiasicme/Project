package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.io.Reader;


public class Forecast {

    public double temperature;
    public boolean rain = false;
    public boolean snow = false;
    public double windspeed;
    private String status;

    public Forecast(Location chosenLocation, Date date) throws IOException {

        String API_URL = "http://api.openweathermap.org/data/2.5/weather?lat="+chosenLocation.latitude+"&lon="+chosenLocation.longitude+"&appid=6d3be0cf8606812a5623b693d6b9197e";
        JSONObject json = Forecast.readJsonFromUrl(API_URL);
        System.out.println(json.toString()); //wypisuje calego
        temperature = json.getJSONObject("main").getDouble("temp") - 273.0;
        JSONArray arr = json.getJSONArray("weather");
            if(json.has("rain"))
                rain = true;
            else if(json.has("snow"))
                snow = true;

        windspeed = json.getJSONObject("wind").getDouble("speed");
        System.out.println("temperatura: " + temperature);
        System.out.println("deszcz: " + rain);
        System.out.println("snieg: " + snow);
        System.out.println("predkosc wiatru: " + windspeed);
    }

    public Forecast(Location chosenLocation) throws IOException {

        //System.out.println("not implemented");
        String API_URL = "http://api.openweathermap.org/data/2.5/weather?lat="+chosenLocation.latitude+"&lon="+chosenLocation.longitude+"&appid=6d3be0cf8606812a5623b693d6b9197e";
        JSONObject json = Forecast.readJsonFromUrl(API_URL);
        //System.out.println(json.toString()); //wypisuje calego
        temperature = json.getJSONObject("main").getDouble("temp") - 273.0;
        if(json.getJSONObject("weather").getString("description") == "rain")
            rain = true;
        else if(json.getJSONObject("weather").getString("description") == "snow")
            snow = true;
        windspeed = json.getJSONObject("wind").getDouble("speed");
        System.out.println("temperatura: " + temperature);
        System.out.println("deszcz: " + rain);
        System.out.println("snieg: " + snow);
        System.out.println("predkosc wiatru: " + windspeed);
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}
