package org.example;

public class Student {
    String id, name;
    int age;
    double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}
