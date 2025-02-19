package com.hands_on_practice_problems.validate_email_using_json_schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import java.io.File;
import java.util.Set;

public class ValidateJsonEmail {
    public static void main(String[] args) {
        try {
            // Load JSON Schema
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
            JsonSchema schema = factory.getSchema(new File("src/main/java/com/hands_on_practice_problems/validate_email_using_json_schema/email_schema.json").toURI());

            // Load JSON Data
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("src/main/java/com/hands_on_practice_problems/validate_email_using_json_schema/user.json"));

            // Validate JSON
            Set<ValidationMessage> errors = schema.validate(jsonData);

            // Print validation errors if any
            if (errors.isEmpty()) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON validation errors:");
                errors.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error validating JSON: " + e.getMessage());
        }
    }
}
