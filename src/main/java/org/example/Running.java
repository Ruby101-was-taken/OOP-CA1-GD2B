package org.example;

import java.util.Date;


public class Running extends Activity{
    private double[] intensityValues = {4.1, 7.2, 10, 15.4, 20.8}, kphMileStones = {4, 8, 12, 16, 24};

    public Running(Date date, double duration, double distance, double averageHeartRate) {
        super(date, duration, distance, averageHeartRate);
        super.calculateIntensityValue(kphMileStones, intensityValues);
        super.getCaloriesBurned();
    }
    public Running() {
        // :)
    }

    public Running(Date date){
        super(date, 0, 0, 0);
    }

}
