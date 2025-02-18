package com.advance_problems.convert_csv_data_into_java_objects;

import java.io.*;
import java.util.*;

// Student class to store CSV data
class Student {
    String id, name;
    int age;
    double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}

public class CSVToObjects {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/advance_problems/convert_csv_data_into_java_objects/student.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                students.add(student);
            }

            // Print all students
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
