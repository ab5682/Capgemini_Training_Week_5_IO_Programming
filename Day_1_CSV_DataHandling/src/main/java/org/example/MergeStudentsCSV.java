package org.example;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeStudentsCSV {
    public static void main(String[] args) throws Exception {
        Map<String, String[]> map = new HashMap<>();
        try (CSVReader reader1 = new CSVReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\students1.csv"))) {
            String[] line;
            reader1.readNext();
            while ((line = reader1.readNext()) != null) {
                map.put(line[0], line);
            }
        }

        try (CSVReader reader2 = new CSVReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\students2.csv"));
             CSVWriter writer = new CSVWriter(new FileWriter("merged_students.csv"))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            reader2.readNext();
            String[] line;
            while ((line = reader2.readNext()) != null) {
                String id = line[0];
                String[] part1 = map.get(id);
                if (part1 != null) {
                    writer.writeNext(new String[]{id, part1[1], part1[2], line[1], line[2]});
                }
            }
        }
    }
}
