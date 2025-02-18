package com.advance_problems.read_large_csv_file_efficiently;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        int batchSize = 100; // Number of lines to process at a time
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int batchCounter = 0;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                System.out.println(line); // Process the line (modify as needed)
                recordCount++;
                batchCounter++;

                // Simulate processing in batches
                if (batchCounter >= batchSize) {
                    System.out.println("Processed " + recordCount + " records so far...");
                    batchCounter = 0;
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
