package com.alinje.app;

import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;

public class App {

    public static void main(String[] args){
        WeatherData weatherData = new OpenWeatherData();
        // prints current weather in Gothenburg
        System.out.println(weatherData.getTodaysWeather("Gothenburg").toString());
    }
}
