package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunningTest {
    private Activity.Statuses[] statuses = {Activity.Statuses.ExtremelyLight, Activity.Statuses.VeryLight, Activity.Statuses.Light, Activity.Statuses.Moderate, Activity.Statuses.Vigorous, Activity.Statuses.VeryVigorous, Activity.Statuses.Invalid};
    private double[] intensityValues = {4.1, 7.2, 10, 15.4, 20.8}, kphMileStones = {4, 8, 12, 16, 24};
    // test kmpintensity

    @Test
    void exLightRunKPH(){
        double distance = 1, time = 2000;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[0], r.getIntensityStatus());
    }
    @Test
    void vLightRunKPH(){
        double distance = 1, time = 15;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[1], r.getIntensityStatus());
    }
    @Test
    void lightRunKPH(){
        double distance = 1, time = 7.5;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[2], r.getIntensityStatus());
    }
    @Test
    void modRunKPH(){
        double distance = 1, time = 5;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[3], r.getIntensityStatus());
    }
    @Test
    void vigRunKPH(){
        double distance = 1, time = 3.75;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[4], r.getIntensityStatus());
    }
    @Test
    void vVigRunKPH(){
        double distance = 1, time = 2.5;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[5], r.getIntensityStatus());
    }
    @Test
    void noRunTimeKPH(){
        double distance = 1, time = 0;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[6], r.getIntensityStatus());
    }
    @Test
    void noRunKPH(){
        double distance = 0, time = 120;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[6], r.getIntensityStatus());
    }
}