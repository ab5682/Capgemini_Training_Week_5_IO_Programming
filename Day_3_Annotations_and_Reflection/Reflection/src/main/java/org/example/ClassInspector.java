package org.example;



import java.lang.reflect.*;

public class ClassInspector {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("org.example.Person");
        for (Method m : cls.getDeclaredMethods()) System.out.println("Method: " + m);
        for (Field f : cls.getDeclaredFields()) System.out.println("Field: " + f);
        for (Constructor<?> c : cls.getDeclaredConstructors()) System.out.println("Constructor: " + c);
    }
}

class Person {
    private String name;
    public int getAge() { return 25; }
}

