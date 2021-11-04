package com.example.restapi.model;

import com.google.gson.annotations.SerializedName;

public class JwtResponse {
    @SerializedName("jwt")
    private String jwt;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwt='" + jwt + '\'' +
                '}';
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
