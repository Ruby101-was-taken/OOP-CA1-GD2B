package org.example;                    // Oct 2023
// Demonstrates: Reading from CSV Text File using Scanner and String.split()
//
// A Comma Separated Values (CSV) file is a file with text only data, where each field item (token)
// is separated by a comma. It can be created in an Excel spreadsheet, and saved as type .CSV.
// Each line of data in the file represents the record of one student. (One per row)
// We read each line into a String and then split the line into individual tokens/fields, and
// add each field value as an element into a String array (called data below)
//
// Finally, we access each String token in the array using the appropriate getter to
// parse it into the correct data type and assign it to a variable.
// (String), int or double, as required.

import java.io. * ;
import java.util.Scanner;

public class CSVREADTESTCOLONTHREE {
    public static void main(String[] args) {

        String fileName = "studentDataCSV.csv"; // file should be in the project (below pom.xml)

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // Ali G,20,1.78,3.55   for example

        try (Scanner sc = new Scanner(new File("testData/activity_data_10.csv")))
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

                // Print out the row of field values using format specifiers
                System.out.printf("%-20s %5d %5.2f %5.2f %n",name,age,height,gpa);
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }
}