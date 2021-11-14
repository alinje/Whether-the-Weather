package com.alinje.app;

/**
 * Immutable representation of a weather state
 */
public class Weather {
    private final double rainMm;
    private final double temp;
    private final String desc;

    public Weather(String desc, double rainMm, double temp){
        this.desc = desc;
        this.rainMm = rainMm;
        this.temp = temp;
    }

    public boolean isGrassWet(){
        return true;
    }

    public String toString(){
        return desc + " with " + rainMm + " mm of rain and " + temp + " degrees Celsius.";
    }
}
