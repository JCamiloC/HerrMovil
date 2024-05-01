package com.example.projectpoli;

public class Foto {
    private String imageUrl;
    private String description;

    public Foto(String imageUrl, String description) {
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}