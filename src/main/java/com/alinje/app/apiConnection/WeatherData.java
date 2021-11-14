package com.alinje.app.apiConnection;

import com.alinje.app.Coordinates;
import com.alinje.app.Weather;

/**
 * Interface for fetching weather data
 */
public interface WeatherData {
    public Weather getTodaysWeather(String city);
    public Weather getCurrentWeather(Coordinates c);
}