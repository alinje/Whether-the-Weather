package com.alinje.app;

/**
 * Immutable representation of a weather state
 */
public class Weather {
    private final double humidity;
    private final double temp;
    private final String desc;
    private final String location;
    private final Coordinates coord;

    public Weather(String desc, double humidity, double temp, String location, Coordinates coord){
        this.desc = desc;
        this.humidity = humidity;
        this.temp = temp;
        this.location = location;
        this.coord = coord;
    }

    public boolean isGrassWet(){
        return true;
    }

    public String toString(){
        String weatherString = coord.toString() + ": " + temp + " degrees Celsius, with a humidity of " + humidity + "%.";
        if (location.length() == 0) return weatherString;
        return location + " " + weatherString;
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

    @Override
    public boolean equals (Object o){
        Weather w2;
        try {
            w2 = (Weather) o;
        } catch (ClassCastException e){
            return false;
        }
        return this.coord.equals(w2.coord)
            && this.humidity - w2.humidity < 0.01
            && this.temp - w2.temp < 0.01
            && this.location.equals(w2.location)
            && this.desc.equals(w2.desc);

    }
}
