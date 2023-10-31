package org.example;

public class Student {

    private String name;
    private int age;
    private double height, GPA;

    public Student(String name, int age, double height, double GPA) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", GPA=" + GPA +
                '}';
    }


    public static int compareByName(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }

    //
    public static int compareByNameThenAge(Student s1, Student s2) {
        if (s1.name.equals(s2.name)) {
            return Integer.compare(s1.age, s2.age);
        } else {
            return s1.name.compareTo(s2.name);
        }
    }



}
