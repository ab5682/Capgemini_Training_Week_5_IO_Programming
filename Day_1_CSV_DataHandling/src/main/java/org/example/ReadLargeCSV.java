package org.example;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\large.csv"))) {
            int chunk = 100;
            int count = 0;
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                count++;
                if (count % chunk == 0) {
                    System.out.println("Processed " + count + " records...");
                }
            }
            System.out.println("Total records processed: " + count);
        }
    }
}
