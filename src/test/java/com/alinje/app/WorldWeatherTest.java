package com.alinje.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.alinje.app.apiConnection.APIconnectionMalfunctionException;
import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;
import com.alinje.app.model.Coordinates;
import com.alinje.app.model.Weather;
import com.alinje.app.model.WorldWeather;

import org.junit.Test;


public class WorldWeatherTest {
    //TODO needs better test coverage
    private WeatherData wd = new OpenWeatherData();

    @Test
    public void testGetWorldWeather(){
        Weather nwW = null;
        Weather neW = null;
        Weather swW = null;
        Weather seW = null;
        Weather[][] worldWeather = null;

        try {
            nwW = wd.getCurrentWeather(new Coordinates(-(360/4),  (180/4)));
            neW = wd.getCurrentWeather(new Coordinates((360/4),   (180/4)));
            swW = wd.getCurrentWeather(new Coordinates(-(360/4), -(180/4)));
            seW = wd.getCurrentWeather(new Coordinates((360/4),  -(180/4)));
    
            worldWeather = WorldWeather.getWorldWeather(2, 2, wd);
        } catch (APIconnectionMalfunctionException e){
            assertFalse(true);
        }

        assertTrue( nwW.equals(worldWeather[0][0])
                 && neW.equals(worldWeather[0][1])
                 && swW.equals(worldWeather[1][0])
                 && seW.equals(worldWeather[1][1])
             );

        
    }
    
}
