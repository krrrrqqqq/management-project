package com.example.attendensmanagmentsystem;

public class Student extends User{

    private int id;
    private int totalAbsences;
    private double gpa;
    private String fName;
    private String lName;
    private String gender;

    public Student(int id, int totalAbsences, double gpa, String fName, String lName, String gender){
        this.id = id;
        this.totalAbsences = totalAbsences;
        this.gpa = gpa;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public int getTotalAbsences() {
        return totalAbsences;
    }

    public double getGpa() {
        return gpa;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalAbsences(int totalAbsences) {
        this.totalAbsences = totalAbsences;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
