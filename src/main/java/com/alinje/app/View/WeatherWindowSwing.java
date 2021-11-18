package com.alinje.app.View;

import java.awt.Color;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alinje.app.Weather;

/**
 * Swing interface
 */
public class WeatherWindowSwing extends JFrame implements WeatherWindow {
    private int w;
    private int h;
    private Weather[][] weathers;

    private JPanel brickPane = new JPanel();
    private final int FODDER = 40;

    private BoxLayout box;
    private JLabel exitLabel;




    public WeatherWindowSwing(int w, int h, Weather[][] weathers){

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(w,h));

        //this.setName("Whether the Weather");
        this.setTitle("Whether the Weather");


        this.w = w;
        this.h = h;

        addInstructions(brickPane);


        
        this.weathers = weathers;

        brickPane.setOpaque(false);
        brickPane.setBorder(new EmptyBorder(FODDER, FODDER, FODDER, FODDER));
        
        brickPane.setBounds(0, 0, w-(2*FODDER), h-2*FODDER);

        fillWithWeatherTiles(brickPane);


        brickPane.setVisible(true);

    }

    public void update(Weather[][] weathers){
    public void paint(Graphics g){
        this.setBackground(Color.BLACK);
        this.weathers = weathers;


        fillWithWeatherTiles(brickPane);
    }

   

    private void fillWithWeatherTiles(JPanel c){
        c.removeAll();
        GridLayout grid = new GridLayout(weathers[0].length, weathers.length);
        c.setLayout(grid);

        System.out.println(weathers.length);
        System.out.println(weathers[0].length);




        for (int i = 0; i < weathers.length; i++) {
            for (int j = 0; j < weathers[0].length; j++) {
                WeatherTile tile = new WeatherTile(c.getWidth()/weathers.length, c.getHeight()/weathers[0].length, weathers[i][j]);
                c.add(tile);
                c.setVisible(true);

            }
        }

        
        this.add(brickPane);
    }


    private void addInstructions(JPanel p){
        JPanel instructionsBar = new JPanel();
        instructionsBar.setOpaque(false);
        instructionsBar.setBounds(0, 0, w, 40);
        JLabel text = new JLabel("Press UP to HD enhance the world, press DOWN to simplify it");
        text.setFont(new Font("Monospaced", Font.BOLD, 20));

        instructionsBar.add(text);


        this.add(instructionsBar);
    }


}
