package com.intermediate_problems.search_for_record_in_csv;

import java.io.*;

public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String searchName = "Jane Smith"; // Name to search

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
                    return;
                }
            }

            System.out.println("Employee not found.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
