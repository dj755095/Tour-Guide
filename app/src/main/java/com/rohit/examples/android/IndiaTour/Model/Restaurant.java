package com.rohit.examples.android.IndiaTour.Model;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private final int restaurantImageId;
    private final String restaurantTitle;
    private final float restaurantRating;
    private final String restaurantType;
    private final String restaurantPhone;
    private final String restaurantTime;
    private final String restaurantLocation;

    public Restaurant(int restaurantImageId, String restaurantTitle, float restaurantRating, String restaurantType, String restaurantPhone, String restaurantTime, String restaurantLocation, String restaurantWebsite, String restaurantImage) {
        this.restaurantImageId = restaurantImageId;
        this.restaurantTitle = restaurantTitle;
        this.restaurantRating = restaurantRating;
        this.restaurantType = restaurantType;
        this.restaurantPhone = restaurantPhone;
        this.restaurantTime = restaurantTime;
        this.restaurantLocation = restaurantLocation;
        this.restaurantWebsite = restaurantWebsite;
        this.restaurantImage = restaurantImage;
    }

    private final String restaurantWebsite;

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public  String restaurantImage;

    public Restaurant(int imageId, String title, float rating, String type, String phone, String time, String location, String website) {
        this.restaurantImageId = imageId;
        this.restaurantTitle = title;
        this.restaurantRating = rating;
        this.restaurantType = type;
        this.restaurantPhone = phone;
        this.restaurantTime = time;
        this.restaurantLocation = location;
        this.restaurantWebsite = website;
    }

    public int getRestaurantImageId() {
        return restaurantImageId;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public float getRestaurantRating() {
        return restaurantRating;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public String getRestaurantTime() {
        return restaurantTime;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public String getRestaurantWebsite() {
        return restaurantWebsite;
    }
}