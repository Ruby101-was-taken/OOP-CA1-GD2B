package org.example;

import java.util.Arrays;
import java.util.Date;

public class Swimming extends Activity{
    private double[] intensityValues = {5, 6.3, 7.6, 8.9, 10.2}, kphMileStones = {0.5, 1.25, 2, 2.75, 3.5};

    public Swimming(Date date, double duration, double distance, double averageHeartRate) {
        super(date, duration, distance, averageHeartRate);
        super.calculateIntensityValue(kphMileStones, intensityValues);
        super.getCaloriesBurned();
    }


    @Override
    public String toString() {
        return "Swimming{" +
                "intensityValues=" + Arrays.toString(intensityValues) +
                "} " + super.toString();
    }
}
