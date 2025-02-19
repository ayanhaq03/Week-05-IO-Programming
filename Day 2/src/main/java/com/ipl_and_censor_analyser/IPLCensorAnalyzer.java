package com.ipl_and_censor_analyser;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) {
        String jsonInputFile = "src/main/java/com/ipl_and_censor_analyser/ipl_data.json";
        String jsonOutputFile = "src/main/java/com/ipl_and_censor_analyser/ipl_data_censored.json";
        String csvInputFile = "src/main/java/com/ipl_and_censor_analyser/ipl_data.csv";
        String csvOutputFile = "src/main/java/com/ipl_and_censor_analyser/ipl_data_censored.csv";

        processJsonFile(jsonInputFile, jsonOutputFile);
        processCsvFile(csvInputFile, csvOutputFile);
    }

    private static void processJsonFile(String inputFile, String outputFile) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject match = jsonArray.getJSONObject(i);
                match.put("team1", censorTeamName(match.getString("team1")));
                match.put("team2", censorTeamName(match.getString("team2")));
                match.put("winner", censorTeamName(match.getString("winner")));
                match.put("player_of_match", "REDACTED");
            }

            Files.write(Paths.get(outputFile), jsonArray.toString(4).getBytes());
            System.out.println("Censored JSON file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCsvFile(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine();
            if (line != null) {
                bw.write(line + "\n"); // Write header
            }

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                values[1] = censorTeamName(values[1]);
                values[2] = censorTeamName(values[2]);
                values[5] = censorTeamName(values[5]);
                values[6] = "REDACTED";

                bw.write(String.join(",", values) + "\n");
            }
            System.out.println("Censored CSV file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return teamName;
    }
}
