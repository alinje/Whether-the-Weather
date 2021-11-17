package com.alinje.app;

import com.alinje.app.apiConnection.WeatherData;

public class WorldWeather {

    private Weather[][] worldWeathers;

    private WorldWeather (Weather[][] worldWeathers){
        this.worldWeathers = worldWeathers;
    }

    public static WorldWeather getWorldWeather(int amountParts, WeatherData weatherData){
            return new WorldWeather(getMidValues(amountParts, weatherData));
    }

    private static Weather[][] getMidValues(int amountPartsPoleToPole, WeatherData weatherData){
        double minX = -180;
        double minY = -90;
        double maxX = 80;
        double maxY = 90;
        double xLen = 260;
        double yLen = 180;

        Weather[][] mV = new Weather[amountPartsPoleToPole*2][amountPartsPoleToPole];
        for (int i = 0; i < mV.length; i++) {
            for (int j = 0; j < amountPartsPoleToPole; j++) {
                double xPos = minX + (xLen * (i + 0.5))/(amountPartsPoleToPole * 2);
                double yPos = minY + (yLen * (j + 0.5))/amountPartsPoleToPole;
                Weather weather = weatherData.getCurrentWeather(new Coordinates(xPos, yPos));
                mV[i][j] = weather;
            }
        }

        System.out.println("end of mV");
        return mV;

    }
}
