package com.example.infopariwisataapp.models;

import java.io.Serializable;

public class TouristSpot implements Serializable {
    private String name;
    private String location;
    private String imageName;
    private String description;

    public TouristSpot(String name, String location, String imageName, String description) {
        this.name = name;
        this.location = location;
        this.imageName = imageName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImageName() {
        return imageName;
    }

    public String getDescription() {
        return description;
    }
}
