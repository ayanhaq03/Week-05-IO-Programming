package com.practice_problems.merge_two_json_object;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON objects from two separate files
        JsonNode node1 = objectMapper.readTree(new File("src/main/java/com/practice_problems/merge_two_json_object/json1.json"));
        JsonNode node2 = objectMapper.readTree(new File("src/main/java/com/practice_problems/merge_two_json_object/json2.json"));

        // Create a new ObjectNode to store the merged JSON
        ObjectNode mergedNode = objectMapper.createObjectNode();

        // Merge the fields from both JSON objects
        mergedNode.setAll((ObjectNode) node1);
        mergedNode.setAll((ObjectNode) node2);

        // Convert the merged JSON object back to a string and print it
        String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
        System.out.println("Merged JSON Object:\n" + mergedJson);
    }
}
