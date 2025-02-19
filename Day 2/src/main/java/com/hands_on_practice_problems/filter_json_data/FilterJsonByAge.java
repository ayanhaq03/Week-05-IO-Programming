package com.hands_on_practice_problems.filter_json_data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            // Load JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/java/com/hands_on_practice_problems/filter_json_data/user.json"));

            // Iterate through the JSON array
            for (JsonNode node : rootNode) {
                int age = node.get("age").asInt();
                if (age > 25) {
                    System.out.println(node);
                }
            }
        } catch (Exception e) {
            System.out.println("Error filtering JSON data: " + e.getMessage());
        }
    }
}
