package com.advance_problems.detect_duplicates_in_a_csv_file;

import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "data.csv";
        Map<String, String> records = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                String id = data[0]; // Assume first column is ID

                if (records.containsKey(id)) {
                    duplicates.add(line); // Store duplicate entry
                } else {
                    records.put(id, line);
                }
            }

            // Print duplicate records
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate records found:");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            } else {
                System.out.println("No duplicate records found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
