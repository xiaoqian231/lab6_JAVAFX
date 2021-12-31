package com.example.lab6_fx.model;

import java.util.Comparator;

public class sortByPoints implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // 0: if (x==y)
        //    -1: if (x < y)
        //  1: if (x > y)
        if (o1.getNumberOfCredits() == o2.getNumberOfCredits()) {
            return 0;
        } else if (o1.getNumberOfCredits() > o2.getNumberOfCredits()) {
            return 1;
        } else {
            return -1;
        }
    }
}
