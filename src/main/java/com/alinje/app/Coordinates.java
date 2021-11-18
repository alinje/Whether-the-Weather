package com.alinje.app;

public class Coordinates {
    private final double lon;
    private final double lat;

    private final double minX;
    private final double minY;
    private final double maxX;
    private final double maxY;

    public Coordinates(double lon, double lat, double minX, double minY, double maxX, double maxY){
        this.lon = lon;
        this.lat = lat;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Two given arguments default to max x and y based on the caartesian system.
     * @param lon
     * @param lat
     */
    public Coordinates(double lon, double lat){
        this(lon, lat, -90, -90, 90, 90);

        // TODO this is ugly
        if (lon > 180) lon = 80;
        if (lon < -180) lon = -180;
        if (lat > 90) lon = 90;
        if (lat < -90) lon = -90;
    }

    public double getXcoord() {
        return lon;
    }

    public double getYcoord() {
        return lat;
    }

    @Override
    public String toString(){
        return "(" + lon + "," + lat + ")";
    }

    @Override
    public boolean equals (Object o){
        Coordinates c2;
        try {
            c2 = (Coordinates) o;
        } catch (ClassCastException e){
            return false;
        }
        return (this.lon - c2.lon < 0.01) && (this.lat - c2.lat < 0.01);
    }
}
