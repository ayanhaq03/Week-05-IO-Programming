package com.practice_problems.convert_java_object_to_json;


import org.json.JSONObject;

public class Car {

    public static void main(String[] args) {
        //instance of JSONObject class
        JSONObject obj = new JSONObject();

        //adding data to json object
        obj.put("name","KIA");
        obj.put("model",12345);
        obj.put("color","Black");
        obj.put("type","EV");


        //print data
        System.out.println(obj.toString());

    }
}
