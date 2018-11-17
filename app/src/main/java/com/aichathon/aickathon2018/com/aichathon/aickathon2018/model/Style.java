package com.aichathon.aickathon2018.com.aichathon.aickathon2018.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Style {

    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("name")
    @Expose
    private String name;

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}