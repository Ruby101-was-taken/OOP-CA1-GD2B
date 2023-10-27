package org.example;                // Oct 2023
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Demonstrates the use of sort() and binarySearch()
// to search for matching Student objects.
// A Comparator must be defined to determine the comparison strategy
// used in both the sort() and the binarySearch()

public class Main {
    public static void main(String[] args) {
        System.out.println("Sorting Collections using Comparators");

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Sarah", 10));
        studentList.add(new Student("Jack", 12));
        studentList.add(new Student("Alice", 11));
        System.out.println("Initial List:");
        System.out.println(studentList);

        // Instantiate a Comparator to compare Students by their name field.
        // We use this Comparator in both the sort() and the binarySearch()
        // as the same comparison/ordering must be used in the sort() and the binarySearch()
        // for it to work correctly.
        Comparator<Student> studentNameComparator =
                new Comparator<Student>() {
                        public int compare(Student s1, Student s2) {
                            return s1.getName().compareTo(s2.getName());
                    }
        };

        //TODO The above could be replaced with a lambda function.
        // comment it out and use the lambda approach.

        // sort the list using the student name comparator
        Collections.sort(studentList, studentNameComparator);
        System.out.println("List after sort():");
        System.out.println(studentList);
        // Next create a Student object containing to act as the KEY.
        // Here, we want to search by student name, so we construct
        // the Student with the name to be searched for.

        Student key = new Student("Sarah", 0);
        // the age doesn't matter above, because it is only the name field
        // that is used when matching Student objects

        // search for the key, return its position or negative value if it is not found
        int index = Collections.binarySearch(studentList, key, studentNameComparator );

        if(index >= 0)
            System.out.println("Found " + studentList.get(index) + " at index " + index);
        else
            System.out.println("Not found in list");

        System.out.println("YIPPPEEE");
    }
}