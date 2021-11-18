package com.alinje.app.apiConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStreamReader;
import org.json.*;

import javax.net.ssl.HttpsURLConnection;

import com.alinje.app.Coordinates;
import com.alinje.app.Weather;

/**
 * Implementation of @see WeatherData.java . 
 */
public class OpenWeatherData implements WeatherData {

    Map<String, Weather> weatherBuffer = new HashMap<>();
    
    //key for using the API is obtained from personal config file
    private final String apiKey = Config.apiKey;

    /**
     * @param city A string representation of the target city, in local language.
     * @return The current weather of the argumetn city.
     */
    public Weather getTodaysWeather(String city){
        Weather weather = jsonToWeather(fetchJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric"));
        return weather;
    }

    /**
     * @param c Coordinates of the target city.
     * @return The current weather of the argument city.
     */
    public Weather getCurrentWeather(Coordinates coord){
        weatherBuffer.computeIfAbsent(coord.toString(), (c) -> jsonToWeather(fetchJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?lat=" + (int)coord.getYcoord() + "&lon=" + (int)coord.getXcoord() + "&appid=" + apiKey + "&units=metric")));
        return weatherBuffer.get(coord.toString());
    }

    private JSONObject fetchJsonFromUrl(String urlString){
        String weatherString = "bf";
        System.out.println("räknar!!");
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
        Weather weather = new Weather("",4,2,"", new Coordinates(0, 0));
        try {
            weather = new Weather(obj.getJSONArray("weather").getJSONObject(0).getString("main"),
                                  Double.valueOf( obj.getJSONObject("main").getDouble("humidity")),
                                  Double.valueOf( obj.getJSONObject("main").getDouble("temp")),
                                  obj.getString("name"),
                                  new Coordinates(obj.getJSONObject("coord").getDouble("lon"),obj.getJSONObject("coord").getDouble("lat")));
        } /* catch (JSONException | NullPointerException e){
            e.printStackTrace();
        } */ //TODO fix version problem
        // if JSONobject is not as expected
        catch (JSONException e){
            e.printStackTrace();
        }
        return weather;
    }

}