package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class CSVToObject {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\students.csv"))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Student s = new Student(line[0], line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]));
                students.add(s);
            }
        }
        students.forEach(System.out::println);
    }
}
