package com.basic_problems.read_a_csv_file;

import java.io.*;
import java.util.*;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/basic_problems/read_a_csv_file/student.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] data = line.split(",");

                // Print structured data
                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Age: " + data[2]);
                System.out.println("Marks: " + data[3]);
                System.out.println("-----------------------");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
