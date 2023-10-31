package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {




    public ArrayList<Activity> ActivityReader(String fileName) {

        ArrayList<Activity> allActivities = new ArrayList<Activity>();

        try (Scanner sc = new Scanner(new File(fileName)))
        {
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // read one line at a time into a String, and parse the String into tokens (parts)
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();             // read full line ( delimited by a "\n" )
                String [] tokens = line.split(",");  // split line using a comma as the delimiter (separator)

                String name = tokens[0];  // extract first token/field from the tokens array (i.e. the name)
                int age = Integer.parseInt(tokens[1]);  // e.g. Convert String "19" to int value 19
                double height = Double.parseDouble(tokens[2]);  // e.g. Convert String "1.82" to double 1.82
                double gpa = Double.parseDouble(tokens[3]);
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }

        return allActivities;
    }
}
