package com.practice_problems.parse_json_and_filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON array from file
        JsonNode rootNode = objectMapper.readTree(new File("src/main/java/com/practice_problems/parse_json_and_filter/people.json"));
        ArrayNode filteredArray = objectMapper.createArrayNode();

        // Filter records where age > 25
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filteredArray.add(node);
            }
        }

        // Print filtered JSON
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray));
    }
}

