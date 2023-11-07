package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat; // date related code referenced from https://www.edureka.co/blog/date-format-in-java/ on the 1st of the 11th 2023 at 5:53pm
import java.util.*;
import java.io.IOException;

public class main {


    public static int intInput(String askText) {
        Scanner key = new Scanner(System.in);
        System.out.print(askText + ": ");
        return key.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the activity tracker :3");
        ArrayList<Activity> activities = selectFile();

        boolean runProgram = true;

        boolean mainMenu = true, viewMenu = false, settingsMenu = false, viewTypes = false;
        String[] mainMenuOptions = {"View Activity", "Change File", "Settings"};
        String[] mainMenuOptionsDesc = {"View your saved activity history and related details", "Switch which file you're using", "Change how the program functions"};
        String[] viewMenuOptions = {"View Based on Type", "View All"};
        String[] viewMenuOptionsDesc = {"View specific type of Activity", "View all Activities"};
        String[] viewTypesMenuOptions = {"Sort Based on Date", "Sort Based on Duration", "Sort Based on Distance", "Sort Based on Average Heart Rate", "Sort Based on Calories Burned", "Change Activity"};
        String[] viewTypesMenuOptionsDesc = {"Sorts Activities based on date", "Sorts Activities based on duration of the Activity", "Sorts Activities based on the distance travelled", "Sorts Activities based on your average heart rate during the Activity", "Sorts Activities based on calories burned during the Activity", "Swaps to the next Activity"};
        String[] settingsMenuOptions = {"Toggle Descriptions", "Toggle Settings Path", "Change Activity"};
        String[] settingsMenuOptionsDesc = {"Toggle whether to show these messages", "Toggle whether to show menu path at the top", "Swaps to the next Activity"};

        ArrayList<String> path = new ArrayList<String>();
        path.add("Main Menu");

        Settings settings = new Settings();

        printActivity(activities, settings.sortType);

        while (runProgram) {
            if(mainMenu){
                printTitle(path, settings);
                switch(printMenu(mainMenuOptions, mainMenuOptionsDesc, settings)){
                    case 1:
                        viewMenu = true;
                        mainMenu = false;
                        path.add("View Activity");
                        break;
                    case 2:
                        activities = selectFile();
                        break;
                    case 3:
                        mainMenu = false;
                        settingsMenu = true;
                        path.add("Settings");
                        break;
                    case 0:
                        mainMenu = false;
                        path.remove("Main Menu");
                        break;
                }
            }
            else if(viewMenu){
                printTitle(path, settings);
                switch(printMenu(viewMenuOptions, viewMenuOptionsDesc, settings)){
                    case 1:
                        viewMenu = false;
                        viewTypes = true;
                        path.add("View Based On Type");
                        break;
                    case 2:
                        path.add("View All");
                        break;
                    case 0:
                        mainMenu = true;
                        viewMenu = false;
                        path.remove("View Activity");
                        break;
                }
            }
            else if (viewTypes) {
                printTitle(path, settings);
                System.out.println("Sorting " + settings.sortType + " Activities.");
                switch(printMenu(viewTypesMenuOptions, viewTypesMenuOptionsDesc, settings)) {
                    case 6:
                        settings.swapSortType();
                        break;
                    case 0:
                        viewTypes = false;
                        viewMenu = true;
                        path.remove("View Based On Type");
                        break;
                }
            }
            else if (settingsMenu) {
                printTitle(path, settings);
                System.out.println("Sorting " + settings.sortType + " Activities.");
                switch (printMenu(settingsMenuOptions, settingsMenuOptionsDesc, settings)) {
                    case 1:
                        settings.toggleDescription();
                        break;
                    case 2:
                        settings.togglePath();
                        break;
                    case 3:
                        settings.swapSortType();
                        break;
                    case 0:
                        mainMenu = true;
                        settingsMenu = false;
                        path.remove("Settings");
                        break;
                }
            } else {
                switch (intInput("Would you like to quit? (0:Yes, 1:No)")) {
                    case 0:
                        runProgram = false;
                        break;

                    default:
                        mainMenu = true;
                        path.add("Main Menu");
                        break;
                }
            }
        }

        System.out.println("Activity Tracker Closed....");
    }

    public static ArrayList<Activity> selectFile() {
        // getting file names from directory code referenced from https://www.tutorialspoint.com/how-to-get-list-of-all-files-folders-from-a-folder-in-java on the 5/11/23 at 4:29pm
        //Creating a File object for directory
        File directoryPath = new File("data");
        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("Available Data:");
        for (int i = 0; i < contents.length; i++) {
            System.out.println("[" + i + "]: " + contents[i]);
        }

        int fileToUse = -1;
        while (fileToUse < 0 || fileToUse >= contents.length) {
            fileToUse = intInput("Enter the number of the file you wish to use");

            if (fileToUse < 0 || fileToUse >= contents.length) {
                System.out.println("Invalid!");
            }
        }
        System.out.println("Attempting to read file: " + contents[fileToUse]);
        ArrayList<Activity> activities = ActivityReader("data/" + contents[fileToUse]);
        System.out.println("Successfully read file!");
        System.out.println("Sorting data...");
        Collections.sort(activities);
        System.out.println("Sorted data!");

        return activities;
    }

    public static void printTitle(ArrayList<String> path, Settings settings) {
        System.out.println("\n" +
                "\n" +
                "  ____    __ ______  ____  __ __  ____  ______  __ __      ______  ____    ____    __  __  _    ___  ____  \n" +
                " /    |  /  ]      ||    ||  |  ||    ||      ||  |  |    |      ||    \\  /    |  /  ]|  |/ ]  /  _]|    \\ \n" +
                "|  o  | /  /|      | |  | |  |  | |  | |      ||  |  |    |      ||  D  )|  o  | /  / |  ' /  /  [_ |  D  )\n" +
                "|     |/  / |_|  |_| |  | |  |  | |  | |_|  |_||  ~  |    |_|  |_||    / |     |/  /  |    \\ |    _]|    / \n" +
                "|  _  /   \\_  |  |   |  | |  :  | |  |   |  |  |___, |      |  |  |    \\ |  _  /   \\_ |     \\|   [_ |    \\ \n" +
                "|  |  \\     | |  |   |  |  \\   /  |  |   |  |  |     |      |  |  |  .  \\|  |  \\     ||  .  ||     ||  .  \\\n" +
                "|__|__|\\____| |__|  |____|  \\_/  |____|  |__|  |____/       |__|  |__|\\_||__|__|\\____||__|\\_||_____||__|\\_|\n");
        if(settings.showPaths) {
            String pathString = "";
            for (String s : path) {
                pathString += s + ">";
            }
            pathString = pathString.substring(0, pathString.length() - 1);
            System.out.println(pathString);
        }
    }

    public static int printMenu(String[] menu, String[] desc, Settings settings){
        System.out.println("\nEnter the number beside the option, or type \"0\" to go back.");
        for(int i=0; i<menu.length; i++){
            System.out.print("[" + (i+1) + "]: " + menu[i]);
            if(settings.showDescriptions)
                System.out.print(" (" + desc[i] + ".)");
            System.out.println();
        }
        return intInput("");
    }


    public static void printActivity(ArrayList<Activity> activities, String type){
        System.out.println("=====");
        for(Activity activity : activities){
            String className = activity.getClass().getName();
            String [] classInfo = className.split("\\.");
            className = classInfo[classInfo.length-1];
            if(className.equals(type)){
                System.out.println(className + "(" + activity.getIntensityStatus() + "):\nDistance: " + activity.getDistance() + "km at " + activity.getKPH() + "km/h.\nLasted " + activity.getDuration() + " minutes.\nThe average heart rate was " + activity.getAverageHeartRate() + " bpm.\n" + activity.getCaloriesBurned() + " calories were burned.\nActivity on the " + activity.getDateString() + ".\n=====");
            }
        }
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
