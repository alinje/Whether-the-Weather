package com.alinje.app.Control;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;
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

import org.w3c.dom.events.MouseEvent;


public class ControlImpl implements Control {

    private JFrame window;
    private WeatherData wD = new OpenWeatherData();

    private int xParts = 3;
    private int yParts = 2;

    //TODO default based on window size
    private int amountPartsPoleToPole = 2;

    public ControlImpl(int w, int h){
        //TODO ??
        JFrame.setDefaultLookAndFeelDecorated(false);
        WeatherWindowSwing ww = new WeatherWindowSwing(w/2,h/2, WorldWeather.getWorldWeather(xParts, yParts, wD));

        //ww.setUndecorated(true);

        // if the window is closed down, the application should exit
        ww.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ww.setPreferredSize(new Dimension(w/2,h/2));

        ww.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        xParts++; //TODO max size needed, break?? conflict w down?
                        yParts++;
                        break;
                    case KeyEvent.VK_DOWN:
                        xParts--;
                        yParts--;
                        break;
                    default:
                        break;
                }
                ww.repaint();
                System.out.println("tjo");
                // TODO repaint prompt
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });

        


        ww.pack();
        ww.setLocationRelativeTo(null);
        ww.setVisible(true);

    }


}
