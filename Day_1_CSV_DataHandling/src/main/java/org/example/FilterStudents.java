package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class FilterStudents {
    public static void main(String[] args) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\students.csv"))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                int marks = Integer.parseInt(line[3]);
                if (marks > 80) {
                    System.out.println("ID: " + line[0] + ", Name: " + line[1] +
                            ", Age: " + line[2] + ", Marks: " + line[3]);
                }
            }
        }
    }
}
