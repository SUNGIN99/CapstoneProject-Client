package com.example.capstoneproject.data.auth.response.duplicateuid;

import androidx.annotation.Nullable;

import com.example.capstoneproject.data.auth.response.duplicateuid.CheckUidResult;
import com.google.gson.annotations.SerializedName;

public class DuplicateResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private CheckUidResult result;

    public DuplicateResponse(boolean isSuccess, int code, String message, @Nullable CheckUidResult result) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Nullable
    public CheckUidResult getResult() {
        return result;
    }

    public void setResult(@Nullable CheckUidResult result) {
        this.result = result;
    }
}
