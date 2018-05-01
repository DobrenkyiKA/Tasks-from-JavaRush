package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        setAge(age);
        setName(name);
    }

    public Student getStudentWithAverageGrade(double d) {
        for (Student student : getStudents()) {
            if (student.getAverageGrade() == d) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double d = 0.0;
        Student st = null;
        for (Student student : getStudents()) {
            if (student.getAverageGrade() >= d) {
                st = student;
                d = student.getAverageGrade();
            }
        }
        return st;
    }

    public Student getStudentWithMinAverageGrade(){
        double d = Double.MAX_VALUE;
        Student st = null;
        for (Student student : getStudents()) {
            if (student.getAverageGrade() <= d) {
                st = student;
                d = student.getAverageGrade();
            }
        }
        return st;
    }

    public void expel(Student student){
        getStudents().remove(student);
    }

}