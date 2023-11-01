package org.example;

import java.util.Date;

public class Running extends Activity{
    public Running(Date date, double duration, double distance, double averageHeartRate) {
        super(date, duration, distance, averageHeartRate);
    }

    public void calculateKPHStatus(){// 0    1     2   3    4
        double[] kphMileStones = {4, 8, 12, 16, 24};
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
        double[] distanceMileStones = {4.1, 7.2, 10, 15.4, 20.8};
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
