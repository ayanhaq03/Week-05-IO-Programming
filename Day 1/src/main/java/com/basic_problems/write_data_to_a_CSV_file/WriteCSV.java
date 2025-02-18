package com.basic_problems.write_data_to_a_CSV_file;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/basic_problems/write_data_to_a_CSV_file/employees.csv";

        // Sample employee data
        String[] employees = {
                "101,John Doe,IT,75000",
                "102,Jane Smith,HR,65000",
                "103,Robert Brown,Finance,80000",
                "104,Emily Davis,Marketing,70000",
                "105,Michael Wilson,IT,90000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            // Writing header row
            writer.append("ID,Name,Department,Salary\n");

            // Writing employee records
            for (String employee : employees) {
                writer.append(employee).append("\n");
            }

            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
