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
        Weather nwW = wd.getCurrentWeather(new Coordinates(-(260/6),     -(180/6)    ));
        Weather neW = wd.getCurrentWeather(new Coordinates((260/6) , -(180/6)    ));
        Weather swW = wd.getCurrentWeather(new Coordinates(-(260/6),     (180/6)));
        Weather seW = wd.getCurrentWeather(new Coordinates((260/6) * 2, (180/6)));
    
        //WorldWeather worldWeather = WorldWeather.getWorldWeather(2, 2, wd);
        Weather[][] worldWeather = WorldWeather.getWorldWeather(2, 2, wd);
        assertTrue( nwW.toString().equals(worldWeather[0][0].toString())
                 && neW.toString().equals(worldWeather[0][1].toString())
                 && swW.toString().equals(worldWeather[1][0].toString())
                 && seW.toString().equals(worldWeather[1][1].toString())
             );
    }
    
}
