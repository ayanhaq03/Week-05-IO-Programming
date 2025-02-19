package com.practice_problems.validate_json_structure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJson {
    public static void main(String[] args) {
        try {
            // Creating ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON from file
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/java/com/practice_problems/validate_json_structure/data.json"));

            // Print formatted JSON if valid
            System.out.println("Valid JSON: " + jsonNode.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
