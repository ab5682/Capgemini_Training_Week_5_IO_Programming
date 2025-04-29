package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IPLCensorJSON {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java\\Week 5\\Day 2\\IPL-Censor-Analyzer\\data\\ipl_input.json";
        String outputPath = "output/ipl_output.json";

        String content = new String(Files.readAllBytes(Paths.get(inputPath)));
        JSONArray matches = new JSONArray(content);

        for (int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);

            String team1 = match.getString("team1");
            String team2 = match.getString("team2");
            String winner = match.getString("winner");

            match.put("team1", censorTeam(team1));
            match.put("team2", censorTeam(team2));
            match.put("winner", censorTeam(winner));
            match.put("player_of_match", "REDACTED");

            JSONObject score = match.getJSONObject("score");
            JSONObject censoredScore = new JSONObject();
            for (String key : score.keySet()) {
                censoredScore.put(censorTeam(key), score.getInt(key));
            }
            match.put("score", censoredScore);
        }

        File outputDir = new File("output");
        if (!outputDir.exists()) outputDir.mkdirs();

        FileWriter writer = new FileWriter(outputPath);
        writer.write(matches.toString(2));
        writer.close();
    }

    private static String censorTeam(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return "***";
    }
}
