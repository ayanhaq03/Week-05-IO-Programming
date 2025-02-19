package com.practice_problems.read_json_and_extract_specific_fields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) throws IOException {

        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/java/com/practice_problems/read_json_and_extract_specific_fields/data.json"));

            // Extract specific fields
            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
