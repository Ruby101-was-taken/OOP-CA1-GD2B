package org.example;

import java.util.Comparator;

public class ActivityDistanceComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return (int)(a1.getDistance() - a2.getDistance());//casts to int cuz it needs to be an int :D
    }
}
