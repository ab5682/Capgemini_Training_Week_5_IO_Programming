package org.example;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;

public class DBToJSONReport {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:db/sample.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            JSONObject obj = new JSONObject();
            for (int i = 1; i <= columnCount; i++) {
                obj.put(metaData.getColumnName(i), rs.getObject(i));
            }
            jsonArray.put(obj);
        }

        FileWriter file = new FileWriter("output/report.json");
        file.write(jsonArray.toString(4));
        file.close();

        rs.close();
        stmt.close();
        conn.close();
    }
}
