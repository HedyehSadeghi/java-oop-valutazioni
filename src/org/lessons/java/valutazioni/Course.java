package org.lessons.java.valutazioni;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiFunction;

public class Course {
    //ATTRIBUTI
    private ArrayList<Student> studentList;
    private static int totalDays;

    //COSTRUTTORI
    public Course() {
        totalDays= 300;
        Random random= new Random();
        int numberOfStudents= random.nextInt(10,21);
        studentList = new ArrayList<>();
        for (int i = 0; i <numberOfStudents-1 ; i++) {
            studentList.add(new Student() );
            studentList.get(i).setIdStudent(i+1);
        }
    }

    //GETTER E SETTER
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public int getTotalDays() {
        return totalDays;
    }

    //METODI PUBLIC
    @Override
    public String toString(){
        String string= "Students:\n";
        for (Student student: studentList) {
            string += student.toString() +"\n";
        }
        return string;
    }


    public void addStudent(Student student){
        studentList.add(student);
    }



    public void removeStudent(Student student){
        studentList.remove(student);
    }

    public BigDecimal percentageStudentGraduated(){
        int numberStudentsGraduated= 0;
        for (Student student: studentList) {
            if (student.studentGraduated()){
                numberStudentsGraduated ++;
            }
        }

        BigDecimal percentage= new BigDecimal(numberStudentsGraduated).divide(new BigDecimal(studentList.size()),2, RoundingMode.HALF_DOWN);
        percentage= percentage.multiply(BigDecimal.valueOf(100));
        return percentage;
    }




    //METODI PRIVATE


}
