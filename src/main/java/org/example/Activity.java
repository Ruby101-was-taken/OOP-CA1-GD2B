package org.example;

import java.util.*;

abstract class Activity implements Comparable<Activity> {
    private String intensityStatus = "Very Light";
    private Date date;
    private double duration, distance, averageHeartRate;

    private double intensity = 0, caloriesBurned = 0;

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

    public Activity(){

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

    public void setAverageHeartRate() {
        this.averageHeartRate = averageHeartRate;
    }

    public String getIntensityStatus() {
        return intensityStatus;
    }

    public double getCaloriesBurned() {
        return this.intensity*this.duration;
    }

    public double getKPH(){
        if(this.duration > 0)
            return (this.distance / this.duration) * 60;
        else
            return 0;
    }

    public String getDateString(){
        return date.getDate() + "/" + (date.getMonth()+1) + "/" + (date.getYear()+1900);
    }

    public void setIntensityStatus(String intensityStatus) {
        this.intensityStatus = intensityStatus;
    }


    @Override
    public int compareTo(Activity o){ //natural sort by date
        if (this == null && o == null) return 0;
        if (o == null) return 1;
        return this.date.compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Double.compare(getDuration(), activity.getDuration()) == 0 && Double.compare(getDistance(), activity.getDistance()) == 0 && Double.compare(getAverageHeartRate(), activity.getAverageHeartRate()) == 0 && Objects.equals(getDate(), activity.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getDuration(), getDistance(), getAverageHeartRate());
    }

    public void calculateIntensityValue(double[] kphMileStones, double[] intensityValues){// 0    1     2   3    4
        String status = this.statuses[0];
        double KPH = getKPH();
        if(KPH >= kphMileStones[4]) {
            status = getStatuses()[5];
            setIntensity(intensityValues[4]);
        }
        else if(KPH >= kphMileStones[3]) {
            status = getStatuses()[4];
            setIntensity(intensityValues[3]);
        }
        else if(KPH >= kphMileStones[2]) {
            status = getStatuses()[3];
            setIntensity(intensityValues[2]);
        }
        else if(KPH >= kphMileStones[1]) {
            status = getStatuses()[2];
            setIntensity(intensityValues[1]);
        }
        else if(KPH >= kphMileStones[0]) {
            status = getStatuses()[1];
            setIntensity(intensityValues[0]);
        }
        else if(KPH <= 0)
            status = "Invalid";

        setIntensityStatus(status);
    }



    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "intensityStatus='" + intensityStatus + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", distance=" + distance +
                ", averageHeartRate=" + averageHeartRate +
                ", intensity=" + intensity +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
