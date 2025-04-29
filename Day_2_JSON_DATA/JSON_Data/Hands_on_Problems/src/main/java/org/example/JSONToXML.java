package org.example;

import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONToXML {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java\\Week 5\\Day 2\\json\\person.json")));
        JSONObject json = new JSONObject(content);
        String xml = XML.toString(json);
        System.out.println(xml);
    }
}
