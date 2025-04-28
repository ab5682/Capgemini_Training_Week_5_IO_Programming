package org.example;



import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonToCsvConverter {
    public static void main(String[] args) throws IOException {
        String json = "[{\"id\":1,\"name\":\"John\",\"age\":20},{\"id\":2,\"name\":\"Jane\",\"age\":22}]";
        JSONArray jsonArray = new JSONArray(json);
        CSVWriter writer = new CSVWriter(new FileWriter("students_from_json.csv"));
        writer.writeNext(new String[]{"ID", "Name", "Age"});
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            writer.writeNext(new String[]{
                    String.valueOf(obj.getInt("id")),
                    obj.getString("name"),
                    String.valueOf(obj.getInt("age"))
            });
        }
        writer.close();
    }
}
