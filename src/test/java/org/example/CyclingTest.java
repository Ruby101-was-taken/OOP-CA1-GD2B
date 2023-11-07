package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CyclingTest {
    private String[] statuses = {"Extremely Light", "Very Light", "Light", "Moderate", "Vigorous", "Very Vigorous"};
    private double[] intensityValues = {2, 5, 7, 13, 15}, kphMileStones = {8, 16, 25, 33, 40};
    // test kmpintensity

    @Test
    void exLightCycleKPH(){
        double distance = 1, time = 2000;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[0], c.getIntensityStatus());
    }
    @Test
    void vLightCycleKPH(){
        double distance = 1, time = 7.5;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[1], c.getIntensityStatus());
    }
    @Test
    void lightCycleKPH(){
        double distance = 1, time = 3.75;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[2], c.getIntensityStatus());
    }
    @Test
    void modCycleKPH(){
        double distance = 1, time = 2.4;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[3], c.getIntensityStatus());
    }
    @Test
    void vigCycleKPH(){
        double distance = 1, time = 1.81;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[4], c.getIntensityStatus());
    }
    @Test
    void vVigCycleKPH(){
        double distance = 1, time = 1.5;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals(statuses[5], c.getIntensityStatus());
    }
    @Test
    void noCycleTimeKPH(){
        double distance = 1, time = 0;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals("Invalid", c.getIntensityStatus());
    }
    @Test
    void noCycleKPH(){
        double distance = 0, time = 120;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateIntensityValue(kphMileStones, intensityValues);
        assertEquals("Invalid", c.getIntensityStatus());
    }
}