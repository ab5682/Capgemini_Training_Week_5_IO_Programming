package org.example;

import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter("employees.csv"))) {
            writer.writeNext(new String[]{"ID", "Name", "Department", "Salary"});
            writer.writeNext(new String[]{"201", "John", "IT", "50000"});
            writer.writeNext(new String[]{"202", "Jane", "HR", "48000"});
            writer.writeNext(new String[]{"203", "Mike", "Finance", "53000"});
            writer.writeNext(new String[]{"204", "Anna", "IT", "52000"});
            writer.writeNext(new String[]{"205", "Tom", "Marketing", "47000"});
        }
    }
}
