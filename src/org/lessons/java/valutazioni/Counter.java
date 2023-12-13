package org.lessons.java.valutazioni;

public class Counter {
    private static int counter=0;
    private int id;

    public Counter(){
        id=counter++;
    }

    public final int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
