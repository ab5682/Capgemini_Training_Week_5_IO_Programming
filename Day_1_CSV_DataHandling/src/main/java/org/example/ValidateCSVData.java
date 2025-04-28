package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) throws Exception {
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\contacts.csv"))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                String email = line[2];
                String phone = line[3];
                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();
                if (!validEmail || !validPhone) {
                    System.out.println("Invalid row: " + String.join(",", line));
                }
            }
        }
    }
}
