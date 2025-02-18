package com.basic_problems.read_and_count_rows_in_a_CSV;

import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/basic_problems/read_and_count_rows_in_a_CSV/data.csv";
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }
                rowCount++;
            }

            System.out.println("Total records: " + rowCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
