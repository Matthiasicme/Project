package com.company;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTAPIConnector {
    public static JSONObject getData(String API_URL) throws IOException {

        URL url = new URL(API_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        System.out.println("Connected");
        connection.connect();

        int status = connection.getResponseCode();
        System.out.println("Status: " + status);
        InputStream inStream = connection.getInputStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

        return new JSONObject(content.substring(1, content.length()-1).toString());
    }
}
