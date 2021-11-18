package com.alinje.app.model;

import com.alinje.app.apiConnection.APIconnectionMalfunctionException;
import com.alinje.app.apiConnection.WeatherData;

/**
 * Offering method for finding weathers in grid intersection points in the world.
 */
public class WorldWeather {

    public static final double MIN_LON = -180;
    public static final double MAX_LAT = 90;
    public static final double LON_LEN = 360;
    public static final double LAT_LEN = 180;

    /**
     * Finds weathers in grid intersection points in the world.
     * @param lonAmountParts Amounts of wished points in x-direction. Resets variable if arguments is less than 1 or more than 10.
     * @param latAmountParts Amounts of wished points in y-direction. Resets variable if arguments is less than 1 or more than 10.
     * @param weatherData Weather data object.
     * @return The weather of the world in a matrix where low numbers in both dimensions is the north west, high in both is the south east.
     * @throws APIconnectionMalfunctionException If the API connection malfunctions.
     */
    public static Weather[][] getWorldWeather(int lonAmountParts, int latAmountParts, WeatherData weatherData) throws APIconnectionMalfunctionException{
        if (lonAmountParts < 1){
            lonAmountParts = 1;
        } else if (lonAmountParts > 10) lonAmountParts = 10;

        if (latAmountParts < 1){
            latAmountParts = 1;
        } else if (latAmountParts > 10) latAmountParts = 10;

        return getMidValues(lonAmountParts, latAmountParts, weatherData);
    }

    private static Weather[][] getMidValues(int lonAmountParts, int latAmountParts, WeatherData weatherData) throws APIconnectionMalfunctionException{

        Weather[][] mV = new Weather[latAmountParts][lonAmountParts];

        for (int i = 0; i < latAmountParts; i++) {
            for (int j = 0; j < lonAmountParts; j++) {
                double lonPos = MIN_LON + ((LON_LEN * (j + 0.5))/lonAmountParts);
                double latPos = MAX_LAT - (LAT_LEN * (i + 0.5))/latAmountParts;
                Weather weather = weatherData.getCurrentWeather(new Coordinates(lonPos, latPos));
                mV[i][j] = weather;
            }
        }


        return mV;

    }

}
