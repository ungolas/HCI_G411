package com.example.m3;

public class Dokument {

    private String dokName;
    private String dokLink;
    private String date;
    private String category;

    public Dokument(String dokName, String dokLink, String date, String category) {
        this.dokName = dokName;
        this.dokLink = dokLink;
        this.date = date;
        this.category = category;
    }

    public String getDokName() {
        return dokName;
    }

    public void setDokName(String dokName) {
        this.dokName = dokName;
    }

    public String getDokLink() {
        return dokLink;
    }

    public void setDokLink(String dokLink) {
        this.dokLink = dokLink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
