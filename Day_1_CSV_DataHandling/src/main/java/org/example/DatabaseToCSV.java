package org.example;



import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DatabaseToCSV {
    public static void main(String[] args) throws IOException {
        List<String[]> data = Arrays.asList(
                new String[]{"101", "Alice", "HR", "50000"},
                new String[]{"102", "Bob", "IT", "70000"},
                new String[]{"103", "Carol", "Finance", "60000"}
        );

        CSVWriter writer = new CSVWriter(new FileWriter("employees_db.csv"));
        writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});
        writer.writeAll(data);
        writer.close();
    }
}
