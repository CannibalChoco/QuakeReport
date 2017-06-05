package com.example.android.quakereport;


public class Earthquake {

    private String locationName;
    private double magnitude;
    private long timeInMiliseconds;
    private String url;

    public Earthquake(double magnitude, String locationName, long timeInMiliseconds, String url){
        this.locationName = locationName;
        this.magnitude = magnitude;
        this.timeInMiliseconds = timeInMiliseconds;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "locationName='" + locationName + '\'' +
                ", magnitude=" + magnitude +
                ", timeInMiliseconds=" + timeInMiliseconds +
                ", url='" + url + '\'' +
                '}';
    }
}
