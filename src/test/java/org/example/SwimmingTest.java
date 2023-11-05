package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SwimmingTest {
    private String[] statuses = {"Extremely Light", "Very Light", "Light", "Moderate", "Vigorous", "Very Vigorous"};
    // test kmpintensity

    @Test
    void exLightSwimKPH(){
        double distance = 1, time = 2000;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 1 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals(statuses[0], s.getIntensityStatus());
    }
    @Test
    void vLightSwimKPH(){
        double distance = 1, time = 120;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 2 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals(statuses[1], s.getIntensityStatus());
    }
    @Test
    void lightSwimKPH(){
        double distance = 1, time = 48;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 3 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals(statuses[2], s.getIntensityStatus());
    }
    @Test
    void modSwimKPH(){
        double distance = 1, time = 30;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 4 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals(statuses[3], s.getIntensityStatus());
    }
    @Test
    void vigSwimKPH(){
        double distance = 1, time = 20.82;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 5 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals(statuses[4], s.getIntensityStatus());
    }
    @Test
    void vVigSwimKPH(){
        double distance = 1, time = 17.14;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 6 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals(statuses[5], s.getIntensityStatus());
    }
    @Test
    void noSwimTimeKPH(){
        double distance = 1, time = 0;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 7 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals("Invalid", s.getIntensityStatus());
    }
    @Test
    void noSwimKPH(){
        double distance = 0, time = 120;
        Swimming s = new Swimming(new Date(), time, distance, 100);
        System.out.println("Test 8 - Distance: " + distance + ", Duration:" + time + ".");
        s.calculateIntensityValue();
        assertEquals("Invalid", s.getIntensityStatus());
    }
}