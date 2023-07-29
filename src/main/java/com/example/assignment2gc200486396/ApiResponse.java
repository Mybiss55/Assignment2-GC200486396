package com.example.assignment2gc200486396;

import com.example.assignment2gc200486396.AppNews;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("appnews")
    private AppNews appNews;

    public AppNews getAppNews() {
        return appNews;
    }

    public void setAppNews(AppNews appNews) {
        this.appNews = appNews;
    }
}