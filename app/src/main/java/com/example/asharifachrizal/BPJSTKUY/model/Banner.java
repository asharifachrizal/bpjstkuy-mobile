package com.example.asharifachrizal.BPJSTKUY.model;

import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("caption")
    private String caption;
    @SerializedName("path")
    private String path;
    @SerializedName("created_at")
    private String createdAt;

    public Banner(String caption, String path) {
        this.caption = caption;
        this.path = path;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
