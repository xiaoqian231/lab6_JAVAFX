package com.example.lab6_fx.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Student {
//    private String Name;
//    private String LastName;
//    private StudentCondition Status;
//    private int YearOfBirth;
//    private double NumberOfCredits;
//    private int id;

    private final SimpleIntegerProperty ID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty LastName;
    private final StudentCondition Status;
    private final SimpleIntegerProperty YearOfBirth;
    private final SimpleDoubleProperty NumberOfCredits;

    public Student(Integer id,String name, String lastName, StudentCondition status, Integer yearOfBirth, Double numberOfCredits) {
        super();
        this.Name =new SimpleStringProperty(name);
        this.LastName = new SimpleStringProperty(lastName);
        this.Status =status;
        this.YearOfBirth =new SimpleIntegerProperty(yearOfBirth);
        this.NumberOfCredits =new SimpleDoubleProperty(numberOfCredits);
        this.ID = new SimpleIntegerProperty(id);
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public SimpleStringProperty lastNameProperty() {
        return LastName;
    }

    public SimpleIntegerProperty yearOfBirthProperty() {
        return YearOfBirth;
    }

    public SimpleDoubleProperty numberOfCreditsProperty() {
        return NumberOfCredits;
    }
    public Integer getId() {
        return ID.get();
    }
    public String getName() {
        return Name.get();
    }
    public String getLastName() {
        return LastName.get();
    }
    public Integer getYearOfBirth() {
        return YearOfBirth.get();
    }
    public Double getNumberOfCredits() {
        return NumberOfCredits.get();
    }
    public StudentCondition getStatus() {
        return Status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", Name=" + Name +
                ", LastName=" + LastName +
                ", Status=" + Status +
                ", YearOfBirth=" + YearOfBirth +
                ", NumberOfCredits=" + NumberOfCredits +
                '}';
    }

    public void print() {
        System.out.println(this);
    }


    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }
}
