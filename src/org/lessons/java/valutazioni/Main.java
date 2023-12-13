package org.lessons.java.valutazioni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Course course= new Course();
        System.out.println("TOTAL DAYS: "+ course.getTotalDays());
        System.out.println(course.toString());
        System.out.println("students graduated: "+ course.percentageStudentGraduated() +" %");

        boolean stop= false;
        while (!stop){
            System.out.println("do you wan to remove a student? (1) Do you want to add one? (2) Exit (3)");
            Scanner scanner= new Scanner(System.in);
            String choice=scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("type the student id to remove");
                    int idStudent= Integer.parseInt(scanner.nextLine()) ;   //gestione errori
                    course.removeStudent(idStudent);
                    System.out.println("your new list:\n"+ course.toString());
                    break;
                case "2":
                    course.addStudent(new Student());
                    System.out.println("new list:");
                    System.out.println(course.toString());
                    break;
                case "3":
                    stop=true;
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }

        }


        course.addStudent(new Student());
        System.out.println(course.toString());



    }
}
