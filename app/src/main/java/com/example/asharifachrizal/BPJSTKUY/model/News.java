package com.example.asharifachrizal.BPJSTKUY.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;
    @SerializedName("reporter")
    private String reporter;
    @SerializedName("created_at")
    private String createdAt;

    public News(String title, String body, String reporter, String createdAt) {
        this.title = title;
        this.body = body;
        this.reporter = reporter;
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
