package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterUsers {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\Downloads\\users (1).json")));
        JSONArray arr = new JSONArray(content);

        for (int i = 0; i < arr.length(); i++) {
            JSONObject user = arr.getJSONObject(i);
            if (user.getInt("age") > 25) {
                System.out.println(user);
            }
        }
    }
}
