package com.hands_on_practice_problems.read_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance for handling JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file into a JsonNode object
            JsonNode rootNode = objectMapper.readTree(new File("src/main/java/com/hands_on_practice_problems/read_json_file/data.json"));

            // Iterate over JSON fields and print each key-value pair
            printJson(rootNode, "");
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    // Recursive method to print keys and values from a JSON node
    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // If node is an object, iterate through its fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), parentKey.isEmpty() ? field.getKey() : parentKey + "." + field.getKey());
            }
        } else if (node.isArray()) {
            // If node is an array, iterate through each element
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + "[" + i + "]");
            }
        } else {
            // Print key-value pair if it's a simple field
            System.out.println(parentKey + " : " + node.asText());
        }
    }
}
