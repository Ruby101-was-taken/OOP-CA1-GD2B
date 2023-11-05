package org.example;

public class Settings {
    public boolean showDescriptions = true, showPaths = true;


    public Settings() {
    }


    public void toggleDescription(){
        this.showDescriptions = !this.showDescriptions;
    }
    public void togglePath(){
        this.showPaths = !this.showPaths;
    }
}
