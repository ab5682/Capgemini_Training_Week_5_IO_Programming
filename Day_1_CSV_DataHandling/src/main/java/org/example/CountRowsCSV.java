package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class CountRowsCSV {
    public static void main(String[] args) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader("employees.csv"))) {
            int count = 0;
            reader.readNext();
            while (reader.readNext() != null) {
                count++;
            }
            System.out.println("Total records: " + count);
        }
    }
}

