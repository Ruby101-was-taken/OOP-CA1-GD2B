package org.example;

import java.util.Arrays;
import java.util.Date;


public class Cycling extends Activity{
    private double[] intensityValues = {2, 5, 7, 13, 15}, kphMileStones = {8, 16, 25, 33, 40};

    public Cycling(Date date, double duration, double distance, double averageHeartRate) {
        super(date, duration, distance, averageHeartRate);
        super.calculateIntensityValue(kphMileStones, intensityValues);
        super.getCaloriesBurned();
    }

}
