package com.aichathon.aickathon2018.com.aichathon.aickathon2018.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Garment {

    @SerializedName("bounding_box")
    @Expose
    private BoundingBox boundingBox;
    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("name")
    @Expose
    private String name;

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

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