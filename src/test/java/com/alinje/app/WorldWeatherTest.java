package com.alinje.app;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;

public class WorldWeatherTest {
    private WeatherData wd = new OpenWeatherData();

    @Test
    public void testGetWorldWeather(){
        Weather nwW = wd.getCurrentWeather(new Coordinates(-(360/4),  (180/4)));
        Weather neW = wd.getCurrentWeather(new Coordinates((360/4),   (180/4)));
        Weather swW = wd.getCurrentWeather(new Coordinates(-(360/4), -(180/4)));
        Weather seW = wd.getCurrentWeather(new Coordinates((360/4),  -(180/4)));

        Weather[][] worldWeather = WorldWeather.getWorldWeather(2, 2, wd);


        assertTrue( nwW.equals(worldWeather[0][0])
                 && neW.equals(worldWeather[0][1])
                 && swW.equals(worldWeather[1][0])
                 && seW.equals(worldWeather[1][1])
             );

        
    }
    
}
