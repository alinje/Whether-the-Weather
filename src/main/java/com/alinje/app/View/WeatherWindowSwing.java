package com.alinje.app.View;

import java.awt.Color;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;

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

        this.setName("Whether the Weather");
        this.setTitle("Whether the Weather");


        this.w = w;
        this.h = h;
        //this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        //addTitleBar();
        addInstructions();


        //this.setBounds(FODDER, 30 + FODDER, w-(2*FODDER), h-2*FODDER-30);
        this.weathers = weathers;

        //this.setBorder(new Border); //TODO
        brickPane.setOpaque(false);
        brickPane.setBounds(FODDER, 30 + FODDER, w-(2*FODDER), h-2*FODDER-30);
        //brickPane.setBackground(Color.PINK);

        fillWithWeatherTiles(brickPane);


        brickPane.setVisible(true);

    }

    @Override
    public void paint(Graphics g){
        this.setBackground(Color.BLACK);

        this.setName("Whether the Weather");
        this.setTitle("Whether the Weather");


        this.w = w;
        this.h = h;
        //this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        //addTitleBar();
        addInstructions();


        //this.setBounds(FODDER, 30 + FODDER, w-(2*FODDER), h-2*FODDER-30);
        this.weathers = weathers;

        //this.setBorder(new Border); //TODO
        brickPane.setOpaque(false);
        brickPane.setBounds(FODDER, 30 + FODDER, w-(2*FODDER), h-2*FODDER-30);
        //brickPane.setBackground(Color.PINK);

        fillWithWeatherTiles(brickPane);


        brickPane.setVisible(true);
    }

    private void fillWithWeatherTiles(JPanel c){
        GridLayout grid = new GridLayout(weathers[0].length, weathers.length);

        
        //grid.setHgap(0);
        //grid.setVgap(0);

        for (int i = 0; i < weathers.length; i++) {
            for (int j = 0; j < weathers[0].length; j++) {
                WeatherTile tile = new WeatherTile((c.getWidth())/weathers.length, (c.getHeight())/weathers[0].length, weathers[i][j]);
                c.add(tile);
                c.setVisible(true);
            }
        }

        c.setLayout(grid);
        this.add(brickPane);
    }

    private void addTitleBar(){
        JPanel titleBar = new JPanel();
        //titleBar.setBackground(Color.GREEN);
        titleBar.setBounds(0, 0, w, 30);
        //titleBar.setSize(w, 30);
        JLabel text = new JLabel(this.getTitle());
        text.setFont(new Font("Monospaced", Font.PLAIN, 14));
        titleBar.add(text);

        exitLabel = new JLabel("X");
        titleBar.add(exitLabel);

        this.add(titleBar);
    }

    private void addInstructions(){
        JPanel titleBar = new JPanel();
        titleBar.setOpaque(false);
        titleBar.setBounds(0, 0, w, 40);
        JLabel text = new JLabel("Press UP to HD enhance the world \n Press DOWN to simplify it");
        text.setFont(new Font("Monospaced", Font.PLAIN, 14));
        titleBar.add(text);

        exitLabel = new JLabel("X");
        titleBar.add(exitLabel);

        this.add(titleBar);
    }

    /*
    public void addExitCommand(MouseListener ml) {
        exitLabel.addMouseListener(ml);
    }*/

    public JLabel getExitLabel(){
        return exitLabel;
    }


}
