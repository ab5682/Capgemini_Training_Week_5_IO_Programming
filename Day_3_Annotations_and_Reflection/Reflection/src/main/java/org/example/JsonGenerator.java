package org.example;

import java.lang.reflect.Field;

public class JsonGenerator {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":");
            json.append("\"").append(fields[i].get(obj)).append("\"");
            if (i != fields.length - 1) json.append(",");
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Ram", "Ram@Shyam.com");
        System.out.println(toJson(user));
    }
}

class User {
    String username;
    String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
