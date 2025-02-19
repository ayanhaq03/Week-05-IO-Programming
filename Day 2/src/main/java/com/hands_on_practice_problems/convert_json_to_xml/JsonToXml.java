package com.hands_on_practice_problems.convert_json_to_xml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            // Load JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("src/main/java/com/hands_on_practice_problems/convert_json_to_xml/data.json"));

            // Convert JSON to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xmlOutput = xmlMapper.writeValueAsString(jsonData);

            // Print XML
            System.out.println(xmlOutput);
        } catch (Exception e) {
            System.out.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}
