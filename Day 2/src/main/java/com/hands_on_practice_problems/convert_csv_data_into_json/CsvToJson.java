package com.hands_on_practice_problems.convert_csv_data_into_json;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            File csvFile = new File("src/main/java/com/hands_on_practice_problems/convert_csv_data_into_json/data.csv");

            // Read CSV
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<Object> it = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);
            List<Object> data = it.readAll();

            // Convert to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.writeValue(new File("src/main/java/com/hands_on_practice_problems/convert_csv_data_into_json/output.json"), data);

            System.out.println("CSV converted to JSON successfully.");
        } catch (Exception e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}
