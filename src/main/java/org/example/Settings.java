package org.example;
import  java.util.*;

public class Settings {
    public boolean showDescriptions = true, showPaths = true, simpleActivity = false;
    public String sortType = "Running";
    public String[] allTypes = {"Running", "Swimming", "Cycling"};


    public Settings() {
    }


    public void toggleDescription(){
        this.showDescriptions = !this.showDescriptions;
    }
    public void togglePath(){ this.showPaths = !this.showPaths; }
    public void toggleSimpleActivity(){
        this.simpleActivity = !this.simpleActivity;
    }

    public void swapSortType(){
        int newIndex = 0;
        for(int i=0; i< allTypes.length; i++){
            if(allTypes[i].equals(sortType)){
                newIndex = i+1;
                if(newIndex == allTypes.length)
                    newIndex = 0;
            }
        }

        sortType = allTypes[newIndex];
    }
}
