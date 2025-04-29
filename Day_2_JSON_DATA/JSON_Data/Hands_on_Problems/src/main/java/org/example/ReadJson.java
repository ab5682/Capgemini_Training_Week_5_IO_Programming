package org.example;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJson {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\Downloads\\data1.json")));
        JSONObject json = new JSONObject(content);
        for(String key : json.keySet()) {
            System.out.println(key + ": " + json.get(key));
        }
    }
}
