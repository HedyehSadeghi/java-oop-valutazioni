package org.lessons.java.valutazioni;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;

public class Student {
    //ATTRIBUTI
    private static int counter=1;
    private int idStudent;
    private int missedDays;
    private BigDecimal gpa;

    //COSTRUTTORI
    public Student() {
        Random random= new Random();
        missedDays = random.nextInt(0,Course.totalDays);
        gpa= BigDecimal.valueOf(random.nextDouble()*5);
        idStudent=counter++;
    }

    //SETTER E GETTER
    public int getIdStudent() {
        return idStudent;
    }

    public int getMissedDays() {
        return missedDays;
    }

    public BigDecimal getGpa() {
        return gpa;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    //METODI PUBLIC
    public boolean studentGraduated(){
        int totalDays= Course.totalDays;
        boolean graduated= false;
        if((missedDays/totalDays*100<= 50 && missedDays/totalDays*100>=25) && gpa.compareTo(new BigDecimal(2))==1){   //(missedDays<=50 && missedDays>=25) && gpa>2
            return graduated=true;
        }else if(missedDays/totalDays*100<25 && (gpa.compareTo(new BigDecimal(2))==0 || gpa.compareTo(new BigDecimal(2))==1) ){
            return graduated=true;
        } else{
            return graduated;
        }
    }


    @Override
    public String toString() {
        return "student "+ idStudent+ " missed days: "+ missedDays+ " gpa: "+ gpa.setScale(1, RoundingMode.HALF_DOWN)+ " graduated: " + (studentGraduated()? "yes" : "no");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idStudent == student.idStudent && missedDays == student.missedDays && Objects.equals(gpa, student.gpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, missedDays, gpa);
    }

    //METODI PRIVATE
}
