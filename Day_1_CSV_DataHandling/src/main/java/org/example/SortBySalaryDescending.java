package org.example;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class SortBySalaryDescending {
    public static void main(String[] args) throws Exception {
        List<String[]> data;
        try (CSVReader reader = new CSVReader(new FileReader("employees.csv"))) {
            data = reader.readAll();
        }
        String[] header = data.remove(0);
        data.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));
        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, data.size()); i++) {
            System.out.println(Arrays.toString(data.get(i)));
        }
    }
}
