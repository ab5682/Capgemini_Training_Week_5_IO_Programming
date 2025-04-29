package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSONStructure {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Amit\",\"age\":30}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        if (root.has("name") && root.has("age")) {
            System.out.println("Valid JSON structure.");
        } else {
            System.out.println("Invalid JSON structure.");
        }
    }
}
