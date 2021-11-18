package com.alinje.app;

import com.alinje.app.apiConnection.WeatherData;

public class WorldWeather {

    private Weather[][] worldWeathers;

    private WorldWeather (Weather[][] worldWeathers){
        this.worldWeathers = worldWeathers;
    }


    public static Weather[][] getWorldWeather(int xAmountParts, int yAmountParts, WeatherData weatherData){
        return getMidValues(xAmountParts, yAmountParts, weatherData);
    }

    private static Weather[][] getMidValues(int xAmountParts, int yAmountParts, WeatherData weatherData){
        double minX = -180;
        double minY = -90;
        double maxX = 80;
        double maxY = 90;
        double xLen = 260;
        double yLen = 180;

        Weather[][] mV = new Weather[xAmountParts][yAmountParts];
        for (int i = 0; i < mV.length; i++) {
            for (int j = 0; j < yAmountParts; j++) {
                double xPos = minX + (xLen * (i + 0.5))/(xAmountParts * 2);
                double yPos = minY + (yLen * (j + 0.5))/yAmountParts;
                Weather weather = weatherData.getCurrentWeather(new Coordinates(xPos, yPos));
                mV[i][j] = weather;
            }
        }

        return mV;

    }

    /*
    public Weather getWeather(int x, int y){

    }*/
}
