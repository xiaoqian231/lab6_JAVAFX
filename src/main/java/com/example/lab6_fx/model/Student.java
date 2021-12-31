package com.example.lab6_fx.model;

import java.util.Objects;

public class Student {
    private String Name;
    private String LastName;
    private StudentCondition Status;
    private int YearOfBirth;
    private double NumberOfCredits;
    private int id;

    public Student(String name, String lastName, StudentCondition status, int yearOfBirth, double numberOfCredits) {
        Name = name;
        LastName = lastName;
        Status = status;
        YearOfBirth = yearOfBirth;
        NumberOfCredits = numberOfCredits;
        id = id;
    }



    public void print() {
        System.out.println(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Status=" + Status +
                ", YearOfBirth=" + YearOfBirth +
                ", NumberOfCredits=" + NumberOfCredits +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getYearOfBirth() == student.getYearOfBirth() && Double.compare(student.getNumberOfCredits(), getNumberOfCredits()) == 0 && Objects.equals(getName(), student.getName()) && Objects.equals(getLastName(), student.getLastName()) && getStatus() == student.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getStatus(), getYearOfBirth(), getNumberOfCredits());
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public StudentCondition getStatus() {
        return Status;
    }

    public void setStatus(StudentCondition status) {
        Status = status;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        YearOfBirth = yearOfBirth;
    }

    public double getNumberOfCredits() {
        return NumberOfCredits;
    }

    public void setNumberOfCredits(double numberOfCredits) {
        NumberOfCredits = numberOfCredits;
    }


}
