package org.example;

import java.util.Comparator;

public class ActivityCaloriesComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return (int)(a1.getCaloriesBurned() - a2.getCaloriesBurned());//casts to int cuz it needs to be an int :D
    }
}
