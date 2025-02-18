package com.advance_problems.validate_csv_data_before_processing;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/advance_problems/validate_csv_data_before_processing/contact.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Regex for email validation
        String phoneRegex = "^\\d{10}$"; // Regex for 10-digit phone number

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                Matcher emailMatcher = emailPattern.matcher(data[1]); // Validate email
                Matcher phoneMatcher = phonePattern.matcher(data[2]); // Validate phone

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.println("Invalid row: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
