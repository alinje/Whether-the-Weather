package com.alinje.app.view;

import java.awt.Color;
import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alinje.app.model.Weather;

/**
 * Swing graphical interface
 */
public class WeatherWindowSwing extends JFrame implements WeatherWindow {

    private JPanel brickPane = new JPanel();
    private static final int FODDER = 40;





    public WeatherWindowSwing(int w, int h, Weather[][] weathers){

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(w,h));
        this.setResizable(false);

        this.setTitle("Whether the Weather");


        addInstructions(w);


        

        brickPane.setOpaque(false);
        brickPane.setBorder(new EmptyBorder(FODDER, FODDER, FODDER, FODDER));
        brickPane.setBounds(0, 0, w-(2*FODDER), h-2*FODDER);

        updateTiles(weathers);
        brickPane.setVisible(true);

    }

    public void updateTiles(Weather[][] weathers){
        // if the map returns to this size later, there is no need to reload the map if it is in the buffer
        // TODO add graphical buffer
        fillWithWeatherTiles(brickPane, weathers);
    }

   

    // fills argument c with weather tiles according to weather from argument weathers
    private void fillWithWeatherTiles(JPanel c, Weather[][] weathers){
        if (weathers.length == 0 || weathers[0].length == 0) return;
       
        c.removeAll();

        GridLayout grid = new GridLayout(weathers.length, weathers[0].length);


        for (int i = 0; i < weathers.length; i++) {
            for (int j = 0; j < weathers[0].length; j++) {
                WeatherTile tile = new WeatherTile(c.getWidth()/weathers[0].length, c.getHeight()/weathers.length, weathers[i][j]);
                c.add(tile);
                c.setVisible(true);

            }
        }

        c.setLayout(grid);
        this.add(brickPane);
    }


    // adds instructions to top of window
    private void addInstructions(int w){
        JPanel instructionsBar = new JPanel();
        instructionsBar.setOpaque(false);
        instructionsBar.setBounds(0, 0, w, 40);

        JLabel text = new JLabel("Press UP to HD enhance the world, press DOWN to simplify it");
        text.setFont(new Font("Monospaced", Font.BOLD, 20));

        this.add(instructionsBar);
        instructionsBar.add(text);

    }

    public void setErrorMes(String errorMes) {
        this.brickPane.removeAll();
        this.add(new JLabel(errorMes));
    }


}
