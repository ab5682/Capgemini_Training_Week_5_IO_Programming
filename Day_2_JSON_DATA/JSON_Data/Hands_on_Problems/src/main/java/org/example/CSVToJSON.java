package org.example;

import org.json.CDL;
import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVToJSON {
    public static void main(String[] args) throws Exception {
        String csv = new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java\\Week 5\\Day 2\\csv\\users.csv")));
        JSONArray jsonArray = CDL.toJSONArray(csv);
        System.out.println(jsonArray.toString(2));
    }
}
