package org.example;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class IPLCensorCSV {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java\\Week 5\\Day 2\\IPL-Censor-Analyzer\\data\\ipl_input.csv"));
        List<String[]> allRows = reader.readAll();
        List<String[]> output = new ArrayList<>();

        output.add(allRows.get(0)); // Header

        for (int i = 1; i < allRows.size(); i++) {
            String[] row = allRows.get(i);
            row[1] = maskTeam(row[1]); // team1
            row[2] = maskTeam(row[2]); // team2
            row[5] = maskTeam(row[5]); // winner
            row[6] = "REDACTED";       // player_of_match
            output.add(row);
        }

        CSVWriter writer = new CSVWriter(new FileWriter("output/ipl_output.csv"));
        writer.writeAll(output);
        writer.close();
    }

    static String maskTeam(String name) {
        int spaceIndex = name.indexOf(" ");
        return (spaceIndex == -1) ? "***" : name.substring(0, spaceIndex) + " ***";
    }
}
