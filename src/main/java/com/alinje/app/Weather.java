package com.alinje.app;

/**
 * Immutable representation of a weather state
 */
public class Weather {
    // TODO not actually rain mm!!
    private final double rainMm;
    private final double temp;
    private final String desc;
    private final String location;

    public Weather(String desc, double rainMm, double temp, String location){
        this.desc = desc;
        this.rainMm = rainMm;
        this.temp = temp;
        this.location = location;
    }

    public boolean isGrassWet(){
        return true;
    }

    public String toString(){
        return desc + " with " + rainMm + " mm of rain and " + temp + " degrees Celsius.";
    }

    public String getDesc(){
        return desc;
    }

    public double getTemp(){
        return temp;
    }

    //public enum TempSpan
    // in a bigger project the spans would have been seperate classes
    public String getTempSpan() {
        if (temp < 0.0){
            return "Freezing";
        } else if (temp < 8.0){
            return "Cold";
        } else if (temp < 14.0){
            return "Chilly";
        } else if (temp < 20.0){
            return "Lukewarm";
        } else if (temp < 30.0){
            return "Hot";
        } else {
            return "Very hot";
        }
    }
}
