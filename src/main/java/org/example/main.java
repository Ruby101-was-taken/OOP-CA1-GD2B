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

        boolean mainMenu = true, viewMenu = false, settingsMenu = false, viewTypes = false, viewAll = false, viewDate = false;
        String[] mainMenuOptions = {"View Activity", "Quick View", "Change File", "Settings"};
        String[] mainMenuOptionsDesc = {"View your saved Activity history and related details", "View all Activities now", "Switch which file you're using", "Change how the program functions"};
        String[] viewMenuOptions = {"View Based on Type", "View All", "View Based on Date"};
        String[] viewMenuOptionsDesc = {"View specific type of Activity", "View all Activities", "View Activities from specific dates"};
        String[] viewTypesMenuOptions = {"Sort Based on Date", "Sort Based on Duration", "Sort Based on Distance", "Sort Based on Average Heart Rate", "Sort Based on Calories Burned", "Change Activity"};
        String[] viewTypesMenuOptionsDesc = {"Sorts Activities based on date", "Sorts Activities based on duration of the Activity", "Sorts Activities based on the distance travelled", "Sorts Activities based on your average heart rate during the Activity", "Sorts Activities based on calories burned during the Activity", "Swaps to the next Activity"};
        String[] viewAllMenuOptions = {"Sort Based on Date", "Sort Based on Duration", "Sort Based on Distance", "Sort Based on Average Heart Rate", "Sort Based on Calories Burned"};
        String[] viewAllMenuOptionsDesc = {"Sorts Activities based on date", "Sorts Activities based on duration of the Activity", "Sorts Activities based on the distance travelled", "Sorts Activities based on your average heart rate during the Activity", "Sorts Activities based on calories burned during the Activity"};


        String[] settingsMenuOptions = {"Toggle Descriptions", "Toggle Settings Path", "Change Activity", "Toggle Simplified Activity View"};
        String[] settingsMenuOptionsDesc = {"Toggle whether to show these messages", "Toggle whether to show menu path at the top", "Swaps to the next Activity", "Show Activity data in a simplified format"};

        ArrayList<String> path = new ArrayList<String>();
        path.add("Main Menu");

        Settings settings = new Settings();

        boolean printActivitiesNextLoop = false, printType = true;

        Activity singleActivityToPrint = null;

        while (runProgram) {
            if(path.size() > 0) // don't print title if there is no menu open cuz it crashes cuz the path doesn't exist etc etc blah blah blah
                printTitle(path, settings);
            if (printActivitiesNextLoop){
                if(printType)
                    printActivity(activities, settings.sortType, settings);
                else
                    printActivity(activities, settings);
                printActivitiesNextLoop = false;
                printType = true;
            }

            if(mainMenu){
                switch(printMenu(mainMenuOptions, mainMenuOptionsDesc, settings)){
                    case 1:
                        viewMenu = true;
                        mainMenu = false;
                        path.add("View Activity");
                        break;
                    case 2:
                        Collections.sort(activities, (a1, a2) -> {
                                    return getClassName(a1).compareTo(getClassName(a2)); //casts to int cuz it needs to be an int :D
                                }
                        );
                        printActivitiesNextLoop = true;
                        printType = false;
                        break;
                    case 3:
                        activities = selectFile();
                        break;
                    case 4:
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
                switch(printMenu(viewMenuOptions, viewMenuOptionsDesc, settings)){
                    case 1:
                        viewMenu = false;
                        viewTypes = true;
                        path.add("View Based On Type");
                        break;
                    case 2:
                        viewMenu = false;
                        viewAll = true;
                        path.add("View All");
                        break;
                    case 3:
                        viewMenu = false;
                        viewDate = true;
                        path.add("View Based on Date");
                        break;
                    case 0:
                        mainMenu = true;
                        viewMenu = false;
                        path.remove("View Activity");
                        break;
                }
            }
            else if (viewTypes) {
                System.out.println("Sorting " + settings.sortType + " Activities.");
                switch(printMenu(viewTypesMenuOptions, viewTypesMenuOptionsDesc, settings)) {
                    case 1: //date
                        Collections.sort(activities);
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 2: //duration
                        Collections.sort(activities, new ActivityDurationComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 3: //distance
                        Collections.sort(activities, new ActivityDistanceComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 4: //heart rate
                        Collections.sort(activities, new ActivityHeartRateComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 5: //calories
                        Collections.sort(activities, new ActivityCaloriesComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
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
            else if (viewAll) {
                System.out.println("Sorting " + settings.sortType + " Activities.");
                switch(printMenu(viewAllMenuOptions, viewAllMenuOptionsDesc, settings)) {
                    case 1: //date
                        Collections.sort(activities);
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 2: //duration
                        Collections.sort(activities, new ActivityDurationComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 3: //distance
                        Collections.sort(activities, new ActivityDistanceComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 4: //heart rate
                        Collections.sort(activities, new ActivityHeartRateComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 5: //calories
                        Collections.sort(activities, new ActivityCaloriesComparator());
                        printActivitiesNextLoop = ascOrDesc(activities, settings);
                        break;
                    case 0:
                        viewAll = false;
                        viewMenu = true;
                        path.remove("View All");
                        break;
                }
                if(printActivitiesNextLoop)
                    printType = false;
            }
            else if(viewDate) { //i think I hate this code
                System.out.println(""); //just need a line break here :3
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                boolean canContinue = true;
                int date = -1, month = 0, year;
                if (singleActivityToPrint != null){
                    System.out.println("Note: Only one Activity can be shown from a day.\n====="); //this is something I would fix if I had more time, but I just included it cuz I wanted to use binary search
                    if (settings.simpleActivity)
                        System.out.println(getSimpleView(singleActivityToPrint));
                    else
                        System.out.println(getComplexView(singleActivityToPrint));
                }
                singleActivityToPrint = null;

                Comparator<Activity> activityDateComparator =
                        (a1, a2) -> a1.getDate().compareTo(a2.getDate());
                while(date < 0 || date > 31){
                    date = intInput("[DD/mm/yyyy]Enter the date (or enter 0 to go back)");
                    if(date < 0 || date > 31)
                        System.out.println("Please enter a valid date.");
                }
                if (date!=0){
                    while(month < 1 || month > 12) {
                        month = intInput("[" + date + "/MM/yyyy]Enter the month (As a number)");
                        if(month < 1 || month > 12)
                            System.out.println("Please enter a valid month.");
                    }
                    year = intInput("[" + date + "/" + month + "/YYYY]Enter the year");
                    Date fullDate = null;
                    try {
                        fullDate = dateFormat.parse(createDateString(date, month, year));
                        Activity key = new Running(fullDate);
                        Collections.sort(activities);
                        int index = Collections.binarySearch(activities, key, activityDateComparator);
                        if(index >= 0){
                           singleActivityToPrint = activities.get(index);
                        }
                    }
                    catch (ParseException e){
                        System.out.println("Something went wrong, check you inputted the date correctly and try again...");
                    }
                }
                else{
                    viewDate = false;
                    viewMenu = true;
                    path.remove("View Based on Date");
                }
            }
            else if (settingsMenu) {
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
                    case 4:
                        settings.toggleSimpleActivity();
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

    public static String createDateString(int date, int month, int year){
        String returnString = "";
        if(date < 10)
            returnString += "0";
        returnString += date + "/";
        if(month<10)
            returnString += "0";
        returnString += month + "/" + year;
        return  returnString;
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


    public static void printActivity(ArrayList<Activity> activities, String type, Settings settings){
        System.out.println("=====");
        for(Activity activity : activities){
            String className = getClassName(activity);
            if(className.equals(type)){
                if(!settings.simpleActivity)
                    System.out.println(getComplexView(activity));
                else
                    System.out.println(getSimpleView(activity));
            }
        }
    }
    public static void printActivity(ArrayList<Activity> activities, Settings settings){
        System.out.println("=====");
        for(Activity activity : activities){
            if(!settings.simpleActivity)
                System.out.println(getComplexView(activity));
            else
                System.out.println(getSimpleView(activity));
        }
    }

    public static String getComplexView(Activity activity){
        return getClassName(activity) + "(" + activity.getIntensityStatus() + "):\nDistance: " + activity.getDistance() + "km at " + Math.round(activity.getKPH()) + "km/h.\nLasted " + activity.getDuration() + " minutes.\nThe average heart rate was " + activity.getAverageHeartRate() + " bpm.\n" + activity.getCaloriesBurned() + " calories were burned.\nActivity on the " + activity.getDateString() + ".\n=====";
    }
    public static String getSimpleView(Activity activity){
        return getClassName(activity) + "(" + activity.getIntensityStatus() + "):\nDistance: " + activity.getDistance() + "\nKm/H: " + Math.round(activity.getKPH()) + "\nDuration: " + activity.getDuration() + " minutes.\nAverage heart rate: " + activity.getAverageHeartRate() + " bpm.\nCalories burned: " + activity.getCaloriesBurned() + ".\n" + activity.getDateString() + ".\n=====";
    }

    public static String getClassName(Activity activity){
        String className = activity.getClass().getName();
        String [] classInfo = className.split("\\.");
        className = classInfo[classInfo.length-1];
        return className;
    }

    public static boolean ascOrDesc(ArrayList<Activity> activities, Settings settings){
        String askString;
        if(settings.showDescriptions) {
            askString = "[1] Ascending (Smallest at the top.)\n[2] Descending (Largest at the top.)\n";
        } else {
            askString = "[1] Ascending\n[2] Descending\n";
        }
        switch (intInput(askString)){
            case 1:
                return true; // returns whether or not the list should be printed
            case 2:
                Collections.reverse(activities);
                return true;
            default:
                return false; // false since invalid input
        }
    }



    public static ArrayList<Activity> ActivityReader(String fileName)  {

        ArrayList<Activity> allActivities = new ArrayList<Activity>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        int dupeCount = 0;


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

                Activity placeHolderActivity = new Running();
                if(type.equals("Running"))
                    placeHolderActivity = new Running(date, duration, distance, avgHeartRate);
                else if(type.equals("Swimming"))
                    placeHolderActivity = new Swimming(date, duration, distance, avgHeartRate);
                else if(type.equals("Cycling"))
                    placeHolderActivity = new Cycling(date, duration, distance, avgHeartRate);

                boolean isDuplicate = false;
                for(Activity activity : allActivities){
                    if(activity.equals(placeHolderActivity)){
                        isDuplicate = true;
                        dupeCount++;
                    }
                }

                if(!isDuplicate)
                    allActivities.add(placeHolderActivity);
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }

        if(dupeCount == 1)
            System.out.println("A duplicate was found, they have not been loaded...");
        else
            System.out.println(dupeCount + " duplicates were found, they have not been loaded...");

        return allActivities;
    }
}
