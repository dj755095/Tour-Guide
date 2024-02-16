package com.rohit.examples.android.IndiaTour.Model;

import java.io.Serializable;

/**
 * Model class to get and set Place Data with Adapter
 */
public class Place implements Serializable {
    private final int placeImageId;
    private final String placeTitle;
    private final float placeRating;
    private final String placeType;
    private final String placeTime;
    private final String placePhone;
    private final String placeLocation;



    private String placeImage;


    private final String placeDescription;

    public Place(int imageId, String title, float rating, String type, String time, String phone, String location, String placeDescription, String placeImage) {
        this.placeImageId = imageId;
        this.placeTitle = title;
        this.placeRating = rating;
        this.placeType = type;
        this.placePhone = phone;
        this.placeTime = time;
        this.placeLocation = location;
        this.placeDescription = placeDescription;
        this.placeImage = placeImage;
    }
    public Place(int imageId, String title, float rating, String type, String time, String phone, String location, String placeDescription) {
        this.placeImageId = imageId;
        this.placeTitle = title;
        this.placeRating = rating;
        this.placeType = type;
        this.placePhone = phone;
        this.placeTime = time;
        this.placeLocation = location;
        this.placeDescription = placeDescription;
    }


    public String getPlaceImage() {
        return placeImage;
    }
    public int getPlaceImageId() {
        return placeImageId;
    }

    public String getPlaceTitle() {
        return placeTitle;
    }

    public float getPlaceRating() {
        return placeRating;
    }

    public String getPlaceType() {
        return placeType;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public String getPlaceTime() {
        return placeTime;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }
}