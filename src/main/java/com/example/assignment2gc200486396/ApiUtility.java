package com.example.assignment2gc200486396;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        } catch (Exception e) {
            System.out.println("Error parsing JSON response");
            e.printStackTrace();
        }

        return apiResponse;
    }

    public static ApiResponse getDataFromAPI(String appId){
        String url = "http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid=" + appId + "&count=3&maxlength=300&format=json";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(java.net.URI.create(url)).build();


        try{
            HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch (Exception e){
            System.out.println("Error fetching data from API");
            e.printStackTrace();
        }
        return ApiUtility.getDataFromFile("javaApiFetched.json");
    }
}
