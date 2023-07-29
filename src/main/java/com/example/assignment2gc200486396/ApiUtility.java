package com.example.assignment2gc200486396;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class ApiUtility {
    // parse JSON response and return ApiResponse object
    public static ApiResponse getDataFromFile(String fileName) {
        ApiResponse apiResponse = null;
        Gson gson = new Gson();
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                ){
            apiResponse = gson.fromJson(jsonReader, ApiResponse.class);
            System.out.println(apiResponse);
        } catch (Exception e) {
            System.out.println("Error parsing JSON response");
            e.printStackTrace();
        }

        return apiResponse;
    }
}
