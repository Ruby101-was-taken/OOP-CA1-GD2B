package org.example;

import java.util.Comparator;

public class ActivityDurationComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return (int)(a1.getDuration() - a2.getDuration());//casts to int cuz it needs to be an int :D
    }
}
