package com.example.myapplication.remote;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Getacc {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<data> listData;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<data> getListData() {
        return listData;
    }
    public void setListData(List<data> listData) {
        this.listData = listData;
    }
}
