package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

class User {
    String name;
    int age;
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ConvertListToJson {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 30),
                new User("Bob", 22)
        );

        JSONArray jsonArray = new JSONArray();
        for(User user : users) {
            JSONObject obj = new JSONObject();
            obj.put("name", user.name);
            obj.put("age", user.age);
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString(2));
    }
}
