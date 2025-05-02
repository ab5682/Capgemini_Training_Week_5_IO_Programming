package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Person {
    @JsonField(name = "user_name")
    String username = "Ram";

    @JsonField(name = "user_age")
    int age = 25;
}

class JsonSerializer {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        StringBuilder json = new StringBuilder("{");
        for (var f : p.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField jf = f.getAnnotation(JsonField.class);
                f.setAccessible(true);
                json.append("\"").append(jf.name()).append("\":\"").append(f.get(p)).append("\",");
            }
        }
        json.setLength(json.length() - 1);
        json.append("}");
        System.out.println(json);
    }
}
