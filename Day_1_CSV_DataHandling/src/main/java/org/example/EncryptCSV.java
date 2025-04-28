package org.example;



import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.Base64;

public class EncryptCSV {
    public static void main(String[] args) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter("encrypted.csv"));
        writer.writeNext(new String[]{"Name", "Email", "Salary"});
        writer.writeNext(new String[]{
                "John",
                Base64.getEncoder().encodeToString("john@example.com".getBytes()),
                Base64.getEncoder().encodeToString("70000".getBytes())
        });
        writer.writeNext(new String[]{
                "Jane",
                Base64.getEncoder().encodeToString("jane@example.com".getBytes()),
                Base64.getEncoder().encodeToString("80000".getBytes())
        });
        writer.close();
    }
}
