package com.example.maximovd.weather;

import android.content.Context;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFetch {
    private static final String link = "http://api.openweathermap.org/data/2.5/weather?q=Moscow,ru&units=metric&appid=f178f6d59051ed69c82c4d8a2592ee18";

    public static JSONObject getJSON(){
        try {
            URL url = new URL(String.format(link));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();



            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());


            // This value will be 404 if the request was not
            // successful
            if(data.getInt("cod") != 200){
                return null;
            }

            return data;
        }catch(Exception e){
            return null;
        }
    }
}
