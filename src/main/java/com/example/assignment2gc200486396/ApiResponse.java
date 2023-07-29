package com.example.assignment2gc200486396;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("appId")
    private int appid;
    @SerializedName("newsItems")
    private Game[] newsitems;
    private int count;
}
