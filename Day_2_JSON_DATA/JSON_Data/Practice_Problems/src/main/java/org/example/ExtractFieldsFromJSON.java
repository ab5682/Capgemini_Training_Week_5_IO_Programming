package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtractFieldsFromJSON {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\Downloads\\users.json")));
        JSONArray users = new JSONArray(content);
        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            System.out.println("Name: " + user.getString("name") + ", Email: " + user.getString("email"));
        }
    }
}
