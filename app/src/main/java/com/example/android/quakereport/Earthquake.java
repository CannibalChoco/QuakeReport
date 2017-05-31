package com.example.android.quakereport;


import static com.example.android.quakereport.R.id.date;

public class Earthquake {

    private String locationName;
    private double magnitude;
    private long timeInMiliseconds;

    public Earthquake(double magnitude, String locationName, long timeInMiliseconds){
        this.locationName = locationName;
        this.magnitude = magnitude;
        this.timeInMiliseconds = timeInMiliseconds;
    }

    public String getLocationName() {
        return locationName;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getTimeInMiliseconds() {
        return timeInMiliseconds;
    }
}
