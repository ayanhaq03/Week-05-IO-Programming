package com.advance_problems.merge_two_csv_files;

import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "src/main/java/com/advance_problems/merge_two_csv_files/student1.csv"; // File with ID, Name, Age
        String file2 = "src/main/java/com/advance_problems/merge_two_csv_files/student2.csv"; // File with ID, Marks, Grade
        String outputFile = "src/main/java/com/advance_problems/merge_two_csv_files/merged_students.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                studentData.put(data[0], data); // Store ID as key
            }
        } catch (IOException e) {
            System.err.println("Error reading file1: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (studentData.containsKey(data[0])) {
                    String[] firstPart = studentData.get(data[0]);
                    String mergedRecord = String.join(",", firstPart) + "," + data[1] + "," + data[2];
                    studentData.put(data[0], mergedRecord.split(","));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file2: " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("ID,Name,Age,Marks,Grade\n"); // Write header
            for (String[] record : studentData.values()) {
                writer.write(String.join(",", record) + "\n");
            }
            System.out.println("Merged CSV file created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }
    }
}
