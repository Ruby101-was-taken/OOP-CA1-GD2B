package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunningTest {
    private String[] statuses = {"Extremely Light", "Very Light", "Light", "Moderate", "Vigorous", "Very Vigorous"};
    //test intensity
    @Test
    void exLightRun(){
        double distance = 3;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals(statuses[0], r.getIntensityStatus());
    }
    @Test
    void vlightRun(){
        double distance = 6;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals(statuses[1], r.getIntensityStatus());
    }
    @Test
    void lightRun(){
        double distance = 8;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals(statuses[2], r.getIntensityStatus());
    }
    @Test
    void modRun(){
        double distance = 11;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals(statuses[3], r.getIntensityStatus());
    }
    @Test
    void vigRun(){
        double distance = 16;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals(statuses[4], r.getIntensityStatus());
    }
    @Test
    void vvigRun(){
        double distance = 21;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals(statuses[5], r.getIntensityStatus());
    }
    @Test
    void invalidRun(){
        double distance = -10;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals("Invalid", r.getIntensityStatus());
    }
    @Test
    void zeroRun(){
        double distance = 0;
        Running r = new Running(new Date(), 5, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ".");
        r.calculateIntensityStatus();
        assertEquals("Invalid", r.getIntensityStatus());
    }

    // test kmpintensity

    @Test
    void exLightRunKPH(){
        double distance = 1, time = 2000;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals(statuses[0], r.getKphStatus());
    }
    @Test
    void vLightRunKPH(){
        double distance = 1, time = 15;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals(statuses[1], r.getKphStatus());
    }
    @Test
    void lightRunKPH(){
        double distance = 1, time = 7.5;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals(statuses[2], r.getKphStatus());
    }
    @Test
    void modRunKPH(){
        double distance = 1, time = 5;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals(statuses[3], r.getKphStatus());
    }
    @Test
    void vigRunKPH(){
        double distance = 1, time = 3.75;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals(statuses[4], r.getKphStatus());
    }
    @Test
    void vVigRunKPH(){
        double distance = 1, time = 2.5;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals(statuses[5], r.getKphStatus());
    }
    @Test
    void noRunTimeKPH(){
        double distance = 1, time = 0;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals("Invalid", r.getKphStatus());
    }
    @Test
    void noRunKPH(){
        double distance = 0, time = 120;
        Running r = new Running(new Date(), time, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ", Duration:" + time + ".");
        r.calculateKPHStatus();
        assertEquals("Invalid", r.getKphStatus());
    }
}