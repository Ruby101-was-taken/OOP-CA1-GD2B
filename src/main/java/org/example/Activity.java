package org.example;

import java.util.*;

abstract class Activity implements Comparable<Activity> {
    private String intensityStatus = "Very Light", kphStatus = "Very Light";
    private Date date;
    private double duration, distance, averageHeartRate;

    private String[] statuses = {"Extremely Light", "Very Light", "Light", "Moderate", "Vigorous", "Very Vigorous"};

    public String[] getStatuses() {
        return statuses;
    }

    public Activity(Date date, double duration, double distance, double averageHeartRate) {
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        this.averageHeartRate = averageHeartRate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(double averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public String getIntensityStatus() {
        return intensityStatus;
    }

    public String getKphStatus() {
        return kphStatus;
    }

    abstract void calculateIntensityStatus();
    abstract void               calculateKPHStatus();

    public double getKPH(){
        if(this.duration > 0)
            return (this.distance / this.duration) * 60;
        else
            return 0;
    }

    public void setIntensityStatus(String intensityStatus) {
        this.intensityStatus = intensityStatus;
    }

    public void setKphStatus(String kphStatus) {
        this.kphStatus = kphStatus;
    }

    @Override
    public int compareTo(Activity o){ //natural sort by date
        if (this == null && o == null) return 0;
        if (o == null) return 1;
        return this.date.compareTo(o.getDate());
    }

    public boolean equals(Activity o) {
        return this.duration == o.getDuration() && this.date == o.getDate() && this.averageHeartRate == o.getAverageHeartRate() && this.distance == o.getDistance();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "intensityStatus='" + intensityStatus + '\'' +
                ", kphStatus='" + kphStatus + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", distance=" + distance +
                ", averageHeartRate=" + averageHeartRate +
                '}';
    }
}
