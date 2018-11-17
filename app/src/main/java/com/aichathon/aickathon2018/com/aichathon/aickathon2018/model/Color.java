package com.aichathon.aickathon2018.com.aichathon.aickathon2018.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("color_name")
    @Expose
    private String colorName;
    @SerializedName("hex")
    @Expose
    private String hex;
    @SerializedName("ratio")
    @Expose
    private Double ratio;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

}
