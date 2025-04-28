package org.example;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class UpdateITSalaries {
    public static void main(String[] args) throws Exception {
        List<String[]> updated = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("employees.csv"))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (!line[0].equals("ID") && line[2].equals("IT")) {
                    double salary = Double.parseDouble(line[3]);
                    line[3] = String.valueOf(salary * 1.10);
                }
                updated.add(line);
            }
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("employees_updated.csv"))) {
            writer.writeAll(updated);
        }
    }
}
