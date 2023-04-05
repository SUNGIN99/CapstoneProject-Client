package com.example.capstoneproject.data.game.request;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class PostMatchCodeRequest {
    @SerializedName(value = "matchCode") private String matchCode; // 매칭코드

    public PostMatchCodeRequest(String matchCode) {
        this.matchCode = matchCode;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }
}
