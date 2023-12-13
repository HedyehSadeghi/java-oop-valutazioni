package org.lessons.java.valutazioni;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

public class Course {
    //ATTRIBUTI
    private ArrayList<Student> studentList;
    public static final int totalDays =300;

    //COSTRUTTORI
    public Course() {
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

        student.setIdStudent(studentList.size()+1);
        studentList.add(student);
    }



    public void removeStudent(int i) throws IllegalArgumentException{
        if (i<1 || i> studentList.size()){
            throw new IllegalArgumentException("pick a number between 1 and "+ studentList.size());
        }else {
            studentList.remove(i-1);
        }
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
