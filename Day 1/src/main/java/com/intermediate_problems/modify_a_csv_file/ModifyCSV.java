package com.intermediate_problems.modify_a_csv_file;

import java.io.*;
import java.util.*;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/intermediate_problems/modify_a_csv_file/employees.csv";
        String outputFile = "src/main/java/com/intermediate_problems/modify_a_csv_file/updated_employees.csv";
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Keep header
                    records.add(line);
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]) * 1.10;
                    data[3] = String.valueOf(salary);
                }
                records.add(String.join(",", data));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Updated CSV file created.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
