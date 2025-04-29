package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJSONArray {
    public static void main(String[] args) throws Exception {
        List<Student> students = Arrays.asList(
                new Student("Anu", 21),
                new Student("Vikram", 22)
        );
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        System.out.println(json);
    }
}
