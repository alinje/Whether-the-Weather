package com.alinje.app.control;

import javax.swing.JFrame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import com.alinje.app.model.Weather;
import com.alinje.app.model.WorldWeather;
import com.alinje.app.apiConnection.APIconnectionMalfunctionException;
import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;
import com.alinje.app.view.WeatherWindowSwing;


/**
 * Basic controller for a grid of WeatherTiles
 */
public class BaseControl implements Control {

    private WeatherData wD = new OpenWeatherData();

    // TODO set to 6,7
    private int lonParts = 6;
    private int latParts = 7;

    private WeatherWindowSwing ww = null;



    public BaseControl(int w, int h){

        //TODO abstract controller-view interaction
        try {
            ww = new WeatherWindowSwing(w/2,h/2, WorldWeather.getWorldWeather(lonParts, latParts, wD));
        } catch (APIconnectionMalfunctionException e){
            ww = new WeatherWindowSwing(w/2, h/2, new Weather[0][0]);
            ww.setErrorMes(e.toString());
            e.printStackTrace();
        }


        // if the window is closed down, the application should exit
        ww.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        ww.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        lonParts++; //TODO max size needed, break?? conflict w down?
                        latParts++;
                        break;
                    case KeyEvent.VK_DOWN:
                        lonParts--;
                        latParts--;
                        break;
                    default:
                        break;
                }
                Weather[][] weathers = null;
                try {
                    weathers = WorldWeather.getWorldWeather(lonParts, latParts, wD);
                } catch (APIconnectionMalfunctionException e1) {
                    ww.setErrorMes(e.toString());
                    e1.printStackTrace();
                }
                ww.updateTiles(weathers);
                ww.pack();
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });

    

        ww.pack();
        ww.setLocationRelativeTo(null);
        ww.setVisible(true);

    }


}
