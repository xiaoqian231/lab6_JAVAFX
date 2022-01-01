package com.example.lab6_fx.model;

import java.text.DecimalFormat;
import java.util.*;

public class ClassContainer {


    Map<String, Group> ClassContainer = new HashMap<>();
    List<Group> groupList = new ArrayList<Group>();

    public ClassContainer() {
        infill();
    }

    @Override
    public String toString() {
        return "ClassContainer{" +
                "ClassContainer=" + ClassContainer +
                '}';
    }

    public Group getClassByID(int id) {
        return groupList.get(id);
    }

    public Group getClassByName(String name) {
        return ClassContainer.get(name);
    }

    public int getGroupSize() {
        return ClassContainer.size();
    }
    public int getClassSize(int id){return  groupList.get(id).getMaxNumberStu(); }

    //a. addClass(String, double) - add new group with given name and given capacity to the list of of groups
    public Group addClass(String GroupName, int capacity) {
        Group group = new Group();
        group.setGroupName(GroupName);
        group.setMaxNumberStu(capacity);
        ClassContainer.put(GroupName, group);
        groupList.add(group);
        return group;
    }

    //b. removeClass(String) - removing the group with given name
    public void removeClass(String GroupName) {
        ClassContainer.remove(GroupName);
    }
    public void removeClassBYid(int id) {
        groupList.remove(id);
        ClassContainer.remove(groupList.get(id).getGroupName());
    }
    //c. findEmpty() - returning list of empty groups
    public ArrayList findEmpty() {
        ArrayList<Group> EmptyGroup = new ArrayList<>();
        Set<Map.Entry<String, Group>> set = ClassContainer.entrySet();
        for (Map.Entry<String, Group> entry : set) {
            String key = entry.getKey();
            Group value = entry.getValue();
            if (value.StudentsList.isEmpty()) {
                EmptyGroup.add(value);
            }
        }
        return EmptyGroup;
    }

    // D.. summary() - prints to standard output the information containing:
// group name and percentage filling Add other useful methods and variables
    //nf.format(0.47)
    public void summary() {
        Set<Map.Entry<String, Group>> set = ClassContainer.entrySet();
        DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%   百分比格式，后面不足2位的用0补齐
        for (Map.Entry<String, Group> entry : set) {
            String key = entry.getKey();
            Group value = entry.getValue();
            //double  percentage=value.getMaxNumberStu()/value.StudentNum();
            double percentage = (double) value.StudentNum() / value.getMaxNumberStu();
            System.out.println("group name:" + key + "\n percentage filling" + "\n" + df1.format(percentage));
        }


    }

    private void infill() {
        Student stu1 = new Student(1,"Marta", "Green", StudentCondition.Sick, 1996, 5.0);
        Student stu2 = new Student(2,"Lily", "Jobs", StudentCondition.Absent, 1996, 4.5);
        Student stu3 = new Student(3,"Lucy", "Jobs", StudentCondition.Present, 1994, 3.0);
        Student stu4 = new Student(4,"Max", "Bush", StudentCondition.Present, 1995, 4.0);
        Student stu5 = new Student(5,"Jone", "Bush", StudentCondition.Present, 1995, 4.5);
        Student stu6 = new Student(6,"Marta", "aba", StudentCondition.Present, 1996, 4.5);
        Student stu7 = new Student(7,"Marcin", "Bush", StudentCondition.Present, 1995, 4.0);
        Student stu8 = new Student(8,"Jack", "Bush", StudentCondition.Present, 1995, 4.5);
        Student stu9 = new Student(9,"Mary", "aba", StudentCondition.Present, 1996, 4.5);
        addClass("class1", 10);
        addClass("class2", 20);
        addClass("class3", 30);
        addClass("class4",20);

        getClassByName("class1").addStudent(stu1);
        getClassByName("class1").addStudent(stu2);
        getClassByName("class1").addStudent(stu3);
        getClassByName("class1").addStudent(stu4);

        getClassByName("class2").addStudent(stu5);
        getClassByName("class2").addStudent(stu6);
        getClassByName("class2").addStudent(stu7);

        getClassByName("class3").addStudent(stu8);
        getClassByName("class4").addStudent(stu9);


    }

}
