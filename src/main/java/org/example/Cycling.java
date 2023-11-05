package org.example;

import java.util.Date;

public class Cycling extends Activity{
    public Cycling(Date date, double duration, double distance, double averageHeartRate) {
        super(date, duration, distance, averageHeartRate);
        this.calculateKPHStatus();
        this.calculateIntensityStatus();
    }

    public void calculateKPHStatus(){// 0    1     2   3    4
        double[] kphMileStones = {8, 16, 25, 33, 40};
        String status = super.getStatuses()[0];
        double KPH = super.getKPH();
        if(KPH >= kphMileStones[4])
            status = super.getStatuses()[5];
        else if(KPH >= kphMileStones[3])
            status = super.getStatuses()[4];
        else if(KPH >= kphMileStones[2])
            status = super.getStatuses()[3];
        else if(KPH >= kphMileStones[1])
            status = super.getStatuses()[2];
        else if(KPH >= kphMileStones[0])
            status = super.getStatuses()[1];
        else if(KPH <= 0)
            status = "Invalid";

        super.setKphStatus(status);
    }
    public void calculateIntensityStatus(){// 0    1     2   3    4
        double[] distanceMileStones = {2, 5, 7, 13, 15};
        String status = super.getStatuses()[0];
        if(super.getDistance() >= distanceMileStones[4])
            status = super.getStatuses()[5];
        else if(super.getDistance() >= distanceMileStones[3])
            status = super.getStatuses()[4];
        else if(super.getDistance() >= distanceMileStones[2])
            status = super.getStatuses()[3];
        else if(super.getDistance() >= distanceMileStones[1])
            status = super.getStatuses()[2];
        else if(super.getDistance() >= distanceMileStones[0])
            status = super.getStatuses()[1];
        else if(super.getDistance() <= 0)
            status = "Invalid";

        super.setIntensityStatus(status);
    }
}
