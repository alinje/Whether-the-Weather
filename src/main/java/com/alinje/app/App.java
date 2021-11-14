package com.alinje.app;

import com.alinje.app.Control.Control;
import com.alinje.app.Control.ControlImpl;
import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;

public class App {

    public static void main(String[] args){
        WeatherData weatherData = new OpenWeatherData();
        // prints current weather in Gothenburg
        System.out.println(weatherData.getTodaysWeather("Gothenburg").toString());
        //System.out.println(weatherData.getCurrentWeather(new Coordinates(3.2,8.0)).toString());

        int w = 900;
        int h = 600;

        Control control = new ControlImpl(w,h);
    }
}
