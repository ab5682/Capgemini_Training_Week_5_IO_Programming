package org.example;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(instance, entry.getValue());
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of("name", "Ram", "age", 22);
        Student student = toObject(Student.class, data);
        System.out.println(student.name + " - " + student.age);
    }
}

class Student {
    String name;
    int age;
}
