package com.practice_problems.convert_list_of_objects_into_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonFile {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a list of Person objects
        List<Person> people = Arrays.asList(new Person("Alice", 28), new Person("Bob", 22));

        // Write JSON array to file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/practice_problems/convert_list_of_objects_into_json/people.json"), people);
        System.out.println("JSON written to people.json");
    }
}
