package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SwimmingTest {
    private Activity.Statuses[] statuses = {Activity.Statuses.ExtremelyLight, Activity.Statuses.VeryLight, Activity.Statuses.Light, Activity.Statuses.Moderate, Activity.Statuses.Vigorous, Activity.Statuses.VeryVigorous, Activity.Statuses.Invalid};
    private double[] intensityValues = {5, 6.3, 7.6, 8.9, 10.2}, kphMileStones = {0.5, 1.25, 2, 2.75, 3.5};
    // test kmpintensity

    @Test
    void exLightSwimKPH(){
        double distance = 1, time = 2000;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[0], s.getIntensityStatus());
    }
    @Test
    void vLightSwimKPH(){
        double distance = 1, time = 120;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[1], s.getIntensityStatus());
    }
    @Test
    void lightSwimKPH(){
        double distance = 1, time = 48;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[2], s.getIntensityStatus());
    }
    @Test
    void modSwimKPH(){
        double distance = 1, time = 30;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[3], s.getIntensityStatus());
    }
    @Test
    void vigSwimKPH(){
        double distance = 1, time = 20.82;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[4], s.getIntensityStatus());
    }
    @Test
    void vVigSwimKPH(){
        double distance = 1, time = 17.14;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[5], s.getIntensityStatus());
    }
    @Test
    void noSwimTimeKPH(){
        double distance = 1, time = 0;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[6], s.getIntensityStatus());
    }
    @Test
    void noSwimKPH(){
        double distance = 0, time = 120;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[6], s.getIntensityStatus());
    }
}