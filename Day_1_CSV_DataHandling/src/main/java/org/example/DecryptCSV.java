package org.example;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Base64;

public class DecryptCSV {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("encrypted.csv"));
        reader.readNext();
        String[] line;
        while ((line = reader.readNext()) != null) {
            String name = line[0];
            String email = new String(Base64.getDecoder().decode(line[1]));
            String salary = new String(Base64.getDecoder().decode(line[2]));
            System.out.println(name + " | " + email + " | " + salary);
        }
    }
}
