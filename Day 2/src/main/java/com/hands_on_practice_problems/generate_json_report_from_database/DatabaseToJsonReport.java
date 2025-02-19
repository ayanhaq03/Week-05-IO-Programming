package com.hands_on_practice_problems.generate_json_report_from_database;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL query
        String query = "SELECT id, name, age, email FROM users";

        // JSON Array to hold records
        JSONArray jsonArray = new JSONArray();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Process result set
            while (rs.next()) {
                JSONObject record = new JSONObject();
                record.put("id", rs.getInt("id"));
                record.put("name", rs.getString("name"));
                record.put("age", rs.getInt("age"));
                record.put("email", rs.getString("email"));

                jsonArray.put(record);
            }

            // Write JSON data to file
            try (FileWriter file = new FileWriter("database_report.json")) {
                file.write(jsonArray.toString(4)); // Pretty print with indentation
                System.out.println("JSON report generated successfully.");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
