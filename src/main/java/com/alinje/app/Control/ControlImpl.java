package com.alinje.app.Control;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import com.alinje.app.Coordinates;
import com.alinje.app.Weather;
import com.alinje.app.WorldWeather;
import com.alinje.app.View.WeatherWindow;
import com.alinje.app.View.WeatherWindowSwing;
import com.alinje.app.apiConnection.OpenWeatherData;
import com.alinje.app.apiConnection.WeatherData;


public class ControlImpl implements Control {

    private JFrame window;
    private WeatherData wD = new OpenWeatherData();

    //TODO default based on window size
    private int amountPartsPoleToPole = 2;

    public ControlImpl(int w, int h){
        WeatherWindowSwing ww = new WeatherWindowSwing(w,h, amountPartsPoleToPole);

        window = new JFrame("Whether the Weather");

        // if the window is closed down, the application should exit
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLocation(100,100);

        ww.setPreferredSize(new Dimension(w,h));
        window.add(ww);

        window.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        amountPartsPoleToPole++; //TODO max size needed, break?? conflict w down?
                    case KeyEvent.VK_DOWN:
                        amountPartsPoleToPole = amountPartsPoleToPole > 0 ? amountPartsPoleToPole - 1 : 0;
                    default:
                        break;
                }
                // TODO repaint prompt
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
        window.pack();
        window.setVisible(true);

        Weather[][] temp = WorldWeather.getWorldWeather();
        for (Weather[] weathers : temp) {
            for (Weather weathers2 : weathers) {
                System.out.println(weathers2.toString());
            }
            
        }
    }


}
