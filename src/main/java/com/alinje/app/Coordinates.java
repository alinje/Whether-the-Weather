package com.alinje.app;

public class Coordinates {
    private final double xCoord;
    private final double yCoord;

    private final double minX;
    private final double minY;
    private final double maxX;
    private final double maxY;

    public Coordinates(double xCoord, double yCoord, double minX, double minY, double maxX, double maxY){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Two given arguments default to max x and y based on the caartesian system.
     * @param xCoord
     * @param yCoord
     */
    public Coordinates(double xCoord, double yCoord){
        this(xCoord, yCoord, -90, -90, 90, 90);

        // TODO this is ugly
        if (xCoord > 80) xCoord = 80;
        if (xCoord < -180) xCoord = -180;
        if (yCoord > 90) xCoord = 90;
        if (yCoord < -90) xCoord = -90;
    }

    public double getXcoord() {
        return xCoord;
    }

    public double getYcoord() {
        return yCoord;
    }
}
