package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat; // date related code referenced from https://www.edureka.co/blog/date-format-in-java/ on the 1st of the 11th 2023 at 5:53pm
import java.util.*;

public class main {


    public static void main(String[] args) {
        System.out.println(ActivityReader("testData/activity_data_10.csv").toString());
    }



    public static ArrayList<Activity> ActivityReader(String fileName)  {

        ArrayList<Activity> allActivities = new ArrayList<Activity>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try (Scanner sc = new Scanner(new File(fileName)))
        {
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // read one line at a time into a String, and parse the String into tokens (parts)
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();             // read full line ( delimited by a "\n" )
                String [] tokens = line.split(",");  // split line using a comma as the delimiter (separator)

                String type = tokens[0];
                Date date = null;
                try {
                    date = dateFormat.parse(tokens[1]);
                }
                catch (ParseException e){
                    System.out.println("DATE NOT WORKY!!!!! :O");
                }
                double duration = Double.parseDouble(tokens[2]);
                double distance = Double.parseDouble(tokens[3]);
                double avgHeartRate = Double.parseDouble(tokens[4]);


                if(type.equals("Running"))
                    allActivities.add(new Running(date, duration, distance, avgHeartRate));
                else if(type.equals("Swimmimg"))
                    allActivities.add(new Swimming(date, duration, distance, avgHeartRate));
                else if(type.equals("Cycling"))
                    allActivities.add(new Cycling(date, duration, distance, avgHeartRate));
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }

        return allActivities;
    }
}
