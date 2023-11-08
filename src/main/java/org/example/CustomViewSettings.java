package org.example;

import java.util.ArrayList;

public class CustomViewSettings {
    public int minimumDuration, minimumDistance, minimumHearRate, minimumCalories;
    public ArrayList<String> activities = new ArrayList<>();

    enum SortType {
        Date,
        Calories,
        Distance,
        Duration,
        HeartRate
    }
    public SortType sortType = SortType.Date;

    public CustomViewSettings() {
        minimumCalories = 0;
        minimumDistance = 0;
        minimumDuration = 0;
        minimumHearRate = 0;
        activities.add("Swimming");
        activities.add("Cycling");
        activities.add("Running");
    }

    public void toggle(String type){
        boolean found = false;
        for(int i=0; i<activities.size(); i++){
            String actType = activities.get(i);
            if(actType.equals(type)){
                activities.remove(type);
                found = true;
            }
        }

        if(!found){
            activities.add(type);
        }
    }

    @Override
    public String toString(){
        return "Current Custom Settings\nMinCalories: " + minimumCalories + ", MinDistance: " + minimumDistance + ", MinDuration: " + minimumDuration + ", MinHeartRate: " + minimumHearRate + ".\nIncluded Activities: " + activities.toString() + ".\nSorting by: " + sortType + ".";
    }
}
