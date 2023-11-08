package org.example;

import java.util.Comparator;

public class ActivityHeartRateComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return (int)(a1.getAverageHeartRate() - a2.getAverageHeartRate());//casts to int cuz it needs to be an int :D
    }
}
