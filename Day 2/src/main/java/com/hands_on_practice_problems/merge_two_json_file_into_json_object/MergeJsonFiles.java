package com.hands_on_practice_problems.merge_two_json_file_into_json_object;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Load both JSON files
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json1 = objectMapper.readTree(new File("fsrc/main/java/com/hands_on_practice_problems/merge_two_json_file_into_json_object/json1.json"));
            JsonNode json2 = objectMapper.readTree(new File("src/main/java/com/hands_on_practice_problems/merge_two_json_file_into_json_object/json2.json"));

            // Merge JSON objects
            ((com.fasterxml.jackson.databind.node.ObjectNode) json1).setAll((com.fasterxml.jackson.databind.node.ObjectNode) json2);

            // Write merged JSON to new file
            objectMapper.writeValue(new File("merged.json"), json1);

            System.out.println("Merged JSON written to 'merged.json'");
        } catch (Exception e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }
}
