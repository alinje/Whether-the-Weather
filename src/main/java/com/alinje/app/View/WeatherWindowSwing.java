package com.alinje.app.View;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeatherWindowSwing extends JPanel implements WeatherWindow {
    private int w = 100;
    private int h = 100;
    private int amountPartsPoleToPole = 9;




    public WeatherWindowSwing(int w, int h, int amountPartsPoleToPole){


        this.w = w;
        this.h = h;

        this.amountPartsPoleToPole = amountPartsPoleToPole;

    }

    public void paintComponent(Graphics g){

        for (int i = 0; i < amountPartsPoleToPole; i++) {
            for (int j = 0; j < (amountPartsPoleToPole * 2); j++) {
                
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, h);
    }

}
