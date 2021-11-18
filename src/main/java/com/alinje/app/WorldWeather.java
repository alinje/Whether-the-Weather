package com.alinje.app;

import com.alinje.app.apiConnection.WeatherData;

public class WorldWeather {


    public static Weather[][] getWorldWeather(int lonAmountParts, int latAmountParts, WeatherData weatherData){
        return getMidValues(lonAmountParts, latAmountParts, weatherData);
    }

    private static Weather[][] getMidValues(int lonAmountParts, int latAmountParts, WeatherData weatherData){
        double minLon = -180;
        double minLat = -90;
        double maxLen = 180;
        double maxLat = 90;
        double lonLen = 360;
        double latLen = 180;

        Weather[][] mV = new Weather[latAmountParts][lonAmountParts];
        for (int i = 0; i < latAmountParts; i++) {
            for (int j = 0; j < lonAmountParts; j++) {
                double lonPos = minLon + ((lonLen * (j + 0.5))/lonAmountParts);
                double latPos = maxLat - (latLen * (i + 0.5))/latAmountParts;
                Weather weather = weatherData.getCurrentWeather(new Coordinates(lonPos, latPos));
                mV[i][j] = weather;
            }
        }

        /*
        Weather[][] mV = new Weather[lonAmountParts][latAmountParts];
        for (int i = 0; i < lonAmountParts; i++) {
            for (int j = 0; j < latAmountParts; j++) {
                double lonPos = minLon + (lonLen * (i + 0.5))/lonAmountParts;
                double latPos = minLat + (latLen * (j + 0.5))/latAmountParts;
                Weather weather = weatherData.getCurrentWeather(new Coordinates(lonPos, latPos));
                mV[i][j] = weather;
                System.out.println(weather.toString());
            }
        }*/


        return mV;

    }

    /*
    public Weather getWeather(int x, int y){

    }*/
}
