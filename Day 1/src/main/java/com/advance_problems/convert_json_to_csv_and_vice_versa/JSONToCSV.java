package com.advance_problems.convert_json_to_csv_and_vice_versa;

import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JSONToCSV {
    public static void main(String[] args) {
        String jsonFilePath = "students.json";
        String csvFilePath = "students.csv";

        convertJSONToCSV(jsonFilePath, csvFilePath);
        convertCSVToJSON(csvFilePath, "converted_students.json");
    }

    // Converts JSON to CSV
    public static void convertJSONToCSV(String jsonFile, String csvFile) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(jsonFile))); // Read JSON file
            JSONArray jsonArray = new JSONArray(jsonString); // Parse JSON data

            FileWriter writer = new FileWriter(csvFile);
            writer.write("ID,Name,Age,Marks\n"); // Writing header

            // Iterate through JSON and extract data
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                writer.write(obj.getInt("ID") + "," +
                        obj.getString("Name") + "," +
                        obj.getInt("Age") + "," +
                        obj.getDouble("Marks") + "\n");
            }
            writer.close();
            System.out.println("JSON converted to CSV successfully.");
        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Converts CSV to JSON
    public static void convertCSVToJSON(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            JSONArray jsonArray = new JSONArray();
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("ID", Integer.parseInt(data[0]));
                obj.put("Name", data[1]);
                obj.put("Age", Integer.parseInt(data[2]));
                obj.put("Marks", Double.parseDouble(data[3]));
                jsonArray.put(obj);
            }

            // Write JSON data to file
            Files.write(Paths.get(jsonFile), jsonArray.toString(4).getBytes());
            System.out.println("CSV converted to JSON successfully.");
        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
