package com.intermediate_problems.sort_csv_records_by_columns;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/intermediate_problems/sort_csv_records_by_columns/employees.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            String header = br.readLine(); // Read and store header separately

            while ((line = br.readLine()) != null) {
                records.add(line.split(",")); // Store records in a list
            }

            // Sort records by salary (4th column) in descending order
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            // Print the top 5 highest-paid employees
            System.out.println(header); // Print header
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(",", records.get(i)));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
