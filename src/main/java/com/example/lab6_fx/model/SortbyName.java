package com.example.lab6_fx.model;

import java.util.Comparator;

public class SortbyName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

return o1.getLastName().compareTo(o2.getLastName());
    }
}

