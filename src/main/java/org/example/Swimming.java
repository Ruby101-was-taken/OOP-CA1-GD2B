package org.example;

import java.util.Date;

public class Swimming extends Activity{
    public Swimming(String activityType, Date date, double duration, double distance, double averageHeartRate) {
        super(activityType, date, duration, distance, averageHeartRate);
    }

    public void calculateKPHStatus(){// 0    1     2   3    4
        double[] kphMileStones = {0.5, 1.25, 2, 2.75, 3.5};
        String status = super.getStatuses()[0];
        if(super.getKPH() < kphMileStones[3])
            status = super.getStatuses()[4];
        else if(super.getKPH() < kphMileStones[2])
            status = super.getStatuses()[3];
        else if(super.getKPH() < kphMileStones[1])
            status = super.getStatuses()[2];
        else if(super.getKPH() < kphMileStones[0])
            status = super.getStatuses()[1];

        super.setKphStatus(status);
    }
    public void calculateIntensityStatus(){// 0    1     2   3    4
        double[] distanceMileStones = {5, 6.3, 7.6, 8.9, 10.2};
        String status = super.getStatuses()[0];
        if(super.getKPH() < distanceMileStones[3])
            status = super.getStatuses()[4];
        else if(super.getKPH() < distanceMileStones[2])
            status = super.getStatuses()[3];
        else if(super.getKPH() < distanceMileStones[1])
            status = super.getStatuses()[2];
        else if(super.getKPH() < distanceMileStones[0])
            status = super.getStatuses()[1];

        super.setIntensityStatus(status);
    }
}
