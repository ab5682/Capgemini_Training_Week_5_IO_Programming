package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class SearchEmployeeByName {
    public static void main(String[] args) throws Exception {
        String searchName = "Anna";
        try (CSVReader reader = new CSVReader(new FileReader("employees.csv"))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                if (line[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + line[2] + ", Salary: " + line[3]);
                    return;
                }
            }
            System.out.println("Employee not found");
        }
    }
}
