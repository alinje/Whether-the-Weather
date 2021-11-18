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

import com.alinje.app.model.Coordinates;
import com.alinje.app.model.Weather;

/**
 * Implementation of @see WeatherData.java . Using https://api.openweathermap.org/
 */
public class OpenWeatherData implements WeatherData {

    private Map<String, Weather> weatherBuffer = new HashMap<>();
    
    //key for using the API is obtained from personal config file
    private final String apiKey = Config.apiKey;

    /**
     * @param city A string representation of the target city, in local language.
     * @return The current weather of the argumetn city.
     */
    public Weather getTodaysWeather(String city) throws APIconnectionMalfunctionException {
        // TODO implement buffer
        Weather weather = jsonToWeather(fetchJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric"));
        return weather;
    }

    /**
     * @param c Coordinates of the target city.
     * @return The current weather of the argument city.
     */
    public Weather getCurrentWeather(Coordinates coord) throws APIconnectionMalfunctionException {
        if (weatherBuffer.containsKey(coord.toString())) return weatherBuffer.get(coord.toString());
        Weather weather = jsonToWeather(fetchJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?lat=" + (int)coord.getYcoord() + "&lon=" + (int)coord.getXcoord() + "&appid=" + apiKey + "&units=metric"));
        weatherBuffer.put(coord.toString(), weather);
        return weather;
    }

    // fetches a JSONObject from the open weather API
    private JSONObject fetchJsonFromUrl(String urlString) throws APIconnectionMalfunctionException {
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

        } catch (MalformedURLException e) {
            throw new APIconnectionMalfunctionException("Invalid URL");
        } catch (IOException e) {
            throw new APIconnectionMalfunctionException("Data read failed");
        } 
        return new JSONObject(weatherString);

    
    }

    // convert weather from JSONObject to Weather object
    private Weather jsonToWeather(JSONObject obj) throws APIconnectionMalfunctionException {
        Weather weather = new Weather("",4,2,"", new Coordinates(0, 0));
        try {
            weather = new Weather(obj.getJSONArray("weather").getJSONObject(0).getString("main"),
                                  Double.valueOf( obj.getJSONObject("main").getDouble("humidity")),
                                  Double.valueOf( obj.getJSONObject("main").getDouble("temp")),
                                  obj.getString("name"),
                                  new Coordinates(obj.getJSONObject("coord").getDouble("lon"),obj.getJSONObject("coord").getDouble("lat")));
        } catch (JSONException | NullPointerException e){
            throw new APIconnectionMalfunctionException("API returned unexpected object");
        }
        return weather;
    }

}