package com.example.capstoneproject.data.match.request;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class PostMatchRoom {

    @SerializedName(value = "title") private String title; // 제목
    @SerializedName(value = "content") private String content; // 내용
    @SerializedName(value = "date") private String date; // 경기 시간
    @SerializedName(value = "count") private int number; // 인원 수
    @Nullable @SerializedName(value = "location") private String location; // 지역
    @Nullable @SerializedName(value = "place") private String place; // 장소
    @SerializedName(value = "average") private int average; // 팀 avg
    @SerializedName(value = "networkType") private String networkType; // 네트워크 타입
    @SerializedName(value = "cost") private int cost; // 비용

    public PostMatchRoom(String title, String content, String date, int number, String location, String place, int average, String networkType, int cost) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.number = number;
        this.location = location;
        this.place = place;
        this.average = average;
        this.networkType = networkType;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
