package com.example.lab6_fx.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group {
    private String GroupName;
    private int MaxNumberStu;
    Student Student;

    ArrayList<Student> StudentsList = new ArrayList<>();
    public  Student getStudentByID(int id){
        return StudentsList.get(id);
    }
// how many students
    public int StudentNum(){
      return StudentsList.size();
    }
    // a addStudent(Student) - Adding a student to the group.
    public void addStudent(Student Student) {
        if (StudentsList.size() == MaxNumberStu) {
            System.err.println("capacity is exceeded");
            return;
        }
        for (int i = 0; i < StudentsList.size(); i++) {
            Student s = StudentsList.get(i);
            if (Student.equals(s)) {
                System.out.println("student already exists");
                return;
            }
        }
        StudentsList.add(Student);
    }

//    // b addPoints(Student, double) - add points to specified student
//    public void addPoints(Student Student, double Points) {
//        Student.setNumberOfCredits(Points + Student.getNumberOfCredits());
//    }

    //c deletStudent(Student) - decreasing the number of students by one (deleting a student completely if his points equal to 0.)
    public void decreasingStudent(Student Student) {
        if (Student.getNumberOfCredits() == 0) {
            StudentsList.remove(Student);
        }
    }

//    // d changeCondition(Student, StudentCondition) - changing the condition of a student
//    public void changeCondition(Student Student, StudentCondition StudentCondition) {
//        Student.setStatus(StudentCondition);
//    }
//
//    // e  removePoints(Student, double) - removing the given number of points from the student.
//    public void removePoints(Student Student, double point) {
//        Student.setNumberOfCredits(Student.getNumberOfCredits() - point);
//    }

    // f search(String) - Taking the student's name and returning it. Use Comparator
    //str1.equals(str2);
    public ArrayList search(String name) {
        ArrayList<Student> searchResult = new ArrayList<>();
        for (int i = 0; i < StudentsList.size(); i++) {
            Student s = StudentsList.get(i);
            if (s.getName().equals(name)) {
                searchResult.add(s);
            }
        }
        return searchResult;
    }

    // g searchPartial(String) - Taking a fragment of the student's name and returning all  individuals that match.
    public ArrayList searchPartial(String Par) {
        ArrayList<Student> searchPartial = new ArrayList<>();
        for (int i = 0; i < StudentsList.size(); i++) {
            Student s = StudentsList.get(i);
            if (s.getName().contains(Par) || s.getLastName().contains(Par)) {
                searchPartial.add(s);
            }
        }
        return searchPartial;
    }

    //h countByCondition(StudentCondition) - Returning the number of people with the given condition
    public int countByCondition(StudentCondition SC) {
        int count = 0;
        for (int i = 0; i < StudentsList.size(); i++) {
            Student s = StudentsList.get(i);
            if (s.getStatus().equals(SC)) {
                count++;
            }
        }
        return count;
    }

    //i. summary() - prints information about all people to standard output
    public void summary() {
//        for (int i = 0; i < StudentsList.size(); i++) {
//            System.out.println(StudentsList.get(i).toString());
//        }
        System.out.println(this);
    }

    // j  sortByName() - returning sorted list of students - by name alphabetically
    public ArrayList sortByName() {
        //Collections.sort(al)
        Collections.sort(StudentsList, new SortbyName());
        return StudentsList;
    }

    //k. sortByPoints() - returning the sorted list of students by their number of points - in descending order - use own Comparator
    public ArrayList sortByPoints() {
        Collections.sort(StudentsList, new sortByPoints());
        return StudentsList;
    }

    // l. max() - use Collections.max method
    public Student max() {
        Student student = Collections.max(StudentsList, Comparator.comparing(s -> s.getNumberOfCredits()));
        return student;
    }

    public Group(String groupName, int maxNumberStu) {
        GroupName = groupName;
        MaxNumberStu = maxNumberStu;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public int getMaxNumberStu() {
        return MaxNumberStu;
    }

    public void setMaxNumberStu(int maxNumberStu) {
        MaxNumberStu = maxNumberStu;
    }

    @Override
    public String toString() {
        return "Group{" +
                "GroupName='" + GroupName + '\'' +
                ", MaxNumberStu=" + MaxNumberStu +
                ", Student=" + Student +
                ", StudentsList=" + StudentsList +
                '}';
    }

    public Group() {
    }
}
