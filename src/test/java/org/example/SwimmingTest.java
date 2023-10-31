package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SwimmingTest {
    private String[] statuses = {"Extremely Light", "Very Light", "Light", "Moderate", "Vigorous", "Very Vigorous"};
    //test intensity
    @Test
    void exLightSwim(){
        double distance = 3;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals(statuses[0], s.getIntensityStatus());
    }
    @Test
    void vlightSwim(){
        double distance = 6;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals(statuses[1], s.getIntensityStatus());
    }
    @Test
    void lightSwim(){
        double distance = 7;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals(statuses[2], s.getIntensityStatus());
    }
    @Test
    void modSwim(){
        double distance = 8;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals(statuses[3], s.getIntensityStatus());
    }
    @Test
    void vigSwim(){
        double distance = 9;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals(statuses[4], s.getIntensityStatus());
    }
    @Test
    void vvigSwim(){
        double distance = 11;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals(statuses[5], s.getIntensityStatus());
    }
    @Test
    void invalidSwim(){
        double distance = -10;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals("Invalid", s.getIntensityStatus());
    }
    @Test
    void zeroSwim(){
        double distance = 0;
        Swimming s = new Swimming(new Date(), 5, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ".");
        s.calculateIntensityStatus();
        assertEquals("Invalid", s.getIntensityStatus());
    }

    // test kmpintensity

    @Test
    void exLightSwimKPH(){
        double distance = 1, time = 2000;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateKPHStatus();
        assertEquals(statuses[0], s.getKphStatus());
    }
    @Test
    void vLightSwimKPH(){
        double distance = 1, time = 120;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateKPHStatus();
        assertEquals(statuses[1], s.getKphStatus());
    }
}