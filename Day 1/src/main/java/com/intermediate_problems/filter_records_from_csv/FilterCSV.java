package com.intermediate_problems.filter_records_from_csv;

import java.io.*;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/intermediate_problems/filter_records_from_csv/student.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

