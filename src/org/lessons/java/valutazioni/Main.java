package org.lessons.java.valutazioni;

public class Main {
    public static void main(String[] args) {


        Course course= new Course();
        System.out.println("TOTAL DAYS: "+ course.getTotalDays());
        System.out.println(course.toString());
        System.out.println("students graduated: "+ course.percentageStudentGraduated() +" %");


    }
}
