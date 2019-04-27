package com.example.gezginapp.model;

public class Place {
    int placeImage;

    public int getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(int placeImage) {
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String placeName;
    String description;

    public Place(int placeImage,String placeName,String description){
        this.placeImage=placeImage;
        this.placeName=placeName;
        this.description=description;
    }
}
