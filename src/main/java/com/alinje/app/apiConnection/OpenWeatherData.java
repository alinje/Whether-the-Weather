package com.alinje.app.apiConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import org.json.*;

import javax.net.ssl.HttpsURLConnection;

import com.alinje.app.Coordinates;
import com.alinje.app.Weather;

public class OpenWeatherData implements WeatherData {
    
    //key for using the API is obtained from personal config file
    private final String apiKey = Config.apiKey;

    /**
     * @param city A string representation of the target city, in local language.
     * @returns The current weather of the argumetn city.
     */
    public Weather getTodaysWeather(String city){
        return jsonToWeather(fetchJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey));
    }

    public Weather getCurrentWeather(Coordinates c){
        return jsonToWeather(fetchJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?lat=" + (int)c.getYcoord() + "&lon=" + (int)c.getXcoord() + "&appid=" + apiKey));
    }

    private JSONObject fetchJsonFromUrl(String urlString){
        String weatherString = "bf";

        URL url;
        try {
            url = new URL(urlString);


            HttpsURLConnection con;
            
            con = (HttpsURLConnection) url.openConnection();


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            con.disconnect();

            in.close();
            weatherString = content.toString();

        // TODO Handle exceptions
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return new JSONObject(weatherString);

    
    }

    private Weather jsonToWeather(JSONObject obj){
        Weather weather = new Weather("",4,2);
        try {
            weather = new Weather(obj.getJSONArray("weather").getJSONObject(0).getString("main"),2,1);
        } /* catch (JSONException | NullPointerException e){
            e.printStackTrace();
        } */ //TODO fix version problem
        catch (Exception e){
            e.printStackTrace();
        }
        return weather;
    }

}