package com.alinje.app.View;

import javax.swing.JPanel;

import com.alinje.app.Weather;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class WeatherTile extends JPanel {

    private int w;
    private int h;

    private Weather weather;

    public WeatherTile(int w, int h, Weather weather){
        this.w = w;
        this.h = h;
        this.weather = weather;

        //this.setPreferredSize(new Dimension(w,h));
        //this.setMaximumSize(new Dimension(w,h));
        this.setBounds(0,0, w,h);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(getColor());
        g.fillRect(0, 0, w, h);
    }

    
    private Color getColor(){
        switch(weather.getTempSpan()){
            case "Freezing":
                return new Color(40, 81, 168);
            case "Cold":
                return new Color(100, 212, 212);
            case "Chilly":
                return new Color(159, 231, 94);
            case "Lukewarm":
                return new Color(255, 245, 156);
            case "Hot":
                return new Color(255, 201, 67);
            case "Very hot":
                return new Color(255, 155, 44);
            default:
                return Color.BLACK;
        }
    }

}
