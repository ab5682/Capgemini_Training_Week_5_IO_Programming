package org.example;

import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject().put("name", "John").put("age", 25);
        JSONObject obj2 = new JSONObject().put("email", "john@example.com").put("city", "Delhi");

        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        System.out.println(obj1.toString(2));
    }
}
