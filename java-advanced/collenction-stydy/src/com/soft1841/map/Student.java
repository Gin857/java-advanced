package com.soft1841.map;

public class Student {
    private Integer number;
    private String neme;

    public Student(Integer number, String neme) {
        this.number = number;
        this.neme = neme;
    }
    public Student(){

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNeme() {
        return neme;
    }

    public void setNeme(String neme) {
        this.neme = neme;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", neme='" + neme + '\'' +
                '}';
    }
}
