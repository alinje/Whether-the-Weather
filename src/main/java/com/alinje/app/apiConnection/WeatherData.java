package com.alinje.app.apiConnection;

import com.alinje.app.model.Coordinates;
import com.alinje.app.model.Weather;

/**
 * Interface for fetching weather data
 */
public interface WeatherData {
    public Weather getTodaysWeather(String city) throws APIconnectionMalfunctionException;
    public Weather getCurrentWeather(Coordinates c) throws APIconnectionMalfunctionException;
}