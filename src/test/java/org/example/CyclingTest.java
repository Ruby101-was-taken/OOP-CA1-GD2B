package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CyclingTest {
    private String[] statuses = {"Extremely Light", "Very Light", "Light", "Moderate", "Vigorous", "Very Vigorous"};
    //test intensity
    @Test
    void exLightCycle(){
        double distance = 1;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals(statuses[0], c.getIntensityStatus());
    }
    @Test
    void vlightCycle(){
        double distance = 3;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals(statuses[1], c.getIntensityStatus());
    }
    @Test
    void lightCycle(){
        double distance = 6;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals(statuses[2], c.getIntensityStatus());
    }
    @Test
    void modCycle(){
        double distance = 8;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals(statuses[3], c.getIntensityStatus());
    }
    @Test
    void vigCycle(){
        double distance = 14;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals(statuses[4], c.getIntensityStatus());
    }
    @Test
    void vvigCycle(){
        double distance = 16;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals(statuses[5], c.getIntensityStatus());
    }
    @Test
    void invalidCycle(){
        double distance = -10;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals("Invalid", c.getIntensityStatus());
    }
    @Test
    void zeroCycle(){
        double distance = 0;
        Cycling c = new Cycling(new Date(), 5, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ".");
        c.calculateIntensityStatus();
        assertEquals("Invalid", c.getIntensityStatus());
    }

    // test kmpintensity

    @Test
    void exLightCycleKPH(){
        double distance = 1, time = 2000;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals(statuses[0], c.getKphStatus());
    }
    @Test
    void vLightCycleKPH(){
        double distance = 1, time = 7.5;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals(statuses[1], c.getKphStatus());
    }
    @Test
    void lightCycleKPH(){
        double distance = 1, time = 3.75;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals(statuses[2], c.getKphStatus());
    }
    @Test
    void modCycleKPH(){
        double distance = 1, time = 2.4;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals(statuses[3], c.getKphStatus());
    }
    @Test
    void vigCycleKPH(){
        double distance = 1, time = 1.81;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals(statuses[4], c.getKphStatus());
    }
    @Test
    void vVigCycleKPH(){
        double distance = 1, time = 1.5;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals(statuses[5], c.getKphStatus());
    }
    @Test
    void noCycleTimeKPH(){
        double distance = 1, time = 0;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals("Invalid", c.getKphStatus());
    }
    @Test
    void noCycleKPH(){
        double distance = 0, time = 120;
        Cycling c = new Cycling(new Date(), time, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ", Duration:" + time + ".");
        c.calculateKPHStatus();
        assertEquals("Invalid", c.getKphStatus());
    }
}