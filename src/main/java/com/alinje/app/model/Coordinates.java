package com.alinje.app.model;

/**
 * A simple representation of the geographic coordinates
 */
public class Coordinates {
    private final double lon;
    private final double lat;


    /**
     * Two given arguments default to max x and y based on the caartesian system.
     * @param lon
     * @param lat
     */
    public Coordinates(double lon, double lat){

        if (lon > 180){
            lon = 180;
        } else if (lon < -180) lon = -180;
        if (lat > 90){
            lon = 90;
        } else if (lat < -90) lon = -90;

        this.lon = lon;
        this.lat = lat;
    }

    public double getXcoord() {
        return lon;
    }

    public double getYcoord() {
        return lat;
    }

    @Override
    public String toString(){
        return "(" + lon + ", " + lat + ")";
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
