package com.example.assignment2gc200486396;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class AppNews {

    @SerializedName("appid")
    private int appId;
    @SerializedName("newsitems")
    private List<NewsItem> newsItems;
    private int count;


    public int getAppid() {
        return appId;
    }

    public void setAppid(int appid) {
        this.appId = appid;
    }

    public List<NewsItem> getNewsitems() {
        return newsItems;
    }

    public void setNewsitems(List<NewsItem> newsitems) {
        this.newsItems = newsitems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
