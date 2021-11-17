package com.alinje.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.alinje.app.Control.Control;
import com.alinje.app.Control.ControlImpl;
import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;

public class App {

    public static void main(String[] args){
        WeatherData weatherData = new OpenWeatherData();
        // prints current weather in Gothenburg
        System.out.println(weatherData.getTodaysWeather("Gothenburg").toString());

        int w;
        int h;
        try {
            Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
            w = (int) screenDim.getWidth();
            h = (int) screenDim.getHeight();

        // exception is thrown if security does not allow app to get screen size
        } catch (SecurityException e){
            e.printStackTrace();

            // if that's the case, app sets window to 900x600 dimension
            w = 900;
            h = 600;
        }

        Control control = new ControlImpl(w,h);
    }
}
