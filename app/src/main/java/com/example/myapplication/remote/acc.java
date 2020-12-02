package com.example.myapplication.remote;

//import com.google.gson.annotations.SerializedName;

public class acc {


    @SerializedName("name")
    private String name;
    @SerializedName("Password")
    private String pass;

    public acc(){}

    public acc( String nama, String nomor) {
        this.name = username;
        this.pass = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = username;
    }

    public String getPass() {
        return pass;
    }

    public void setpass(String pass) {
        this.pass = password;
    }

}
