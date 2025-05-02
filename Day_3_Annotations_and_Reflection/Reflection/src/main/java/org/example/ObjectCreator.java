package org.example;

import java.lang.reflect.*;

public class ObjectCreator {
    public static void main(String[] args) throws Exception {
        Constructor<Student> constructor = Student.class.getConstructor(String.class, int.class);
        Student s = constructor.newInstance("Amit", 21);
        System.out.println(s.name + " - " + s.age);
    }
}

class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
