package com.advance_problems.generate_a_csv_report_from_database;
import java.io.*;
import java.sql.*;
public class DatabaseReport {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/company_db"; // Database URL
        String username = "root"; // Database username
        String password = "password"; // Database password
        String outputFile = "employees_report.csv";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             FileWriter writer = new FileWriter(outputFile)) {

            // SQL query to fetch employee details
            String query = "SELECT id, name, department, salary FROM employees";
            ResultSet rs = stmt.executeQuery(query);

            // Writing header row
            writer.write("Employee ID,Name,Department,Salary\n");

            // Writing employee data to CSV file
            while (rs.next()) {
                writer.write(rs.getInt("id") + "," +
                        rs.getString("name") + "," +
                        rs.getString("department") + "," +
                        rs.getDouble("salary") + "\n");
            }

            System.out.println("Employee report generated successfully.");
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
