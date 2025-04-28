package org.example;



import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\Downloads\\students_duplicates.csv";
        Set<String> seenIds = new HashSet<>();
        List<String[]> duplicates = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String id = line[0];
                if (!seenIds.add(id)) {
                    duplicates.add(line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records based on ID:");
                for (String[] dup : duplicates) {
                    System.out.println(Arrays.toString(dup));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
