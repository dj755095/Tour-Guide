package com.rohit.examples.android.IndiaTour.Model;

import java.io.Serializable;

/**
 * Model class to get and set Shop Data with Adapter
 */
public class Shop implements Serializable {
    private final int ShopImageId;
    private final String shopTitle;
    private final float shopRating;
    private final String shopPhone;
    private final String shopPlace;
    private final String shopTime;
    private final String shopLocation;

    public String shopImage;

    public String getShopImage() {
        return shopImage;
    }

    public Shop(int shopImageId, String shopTitle, float shopRating, String shopPhone, String shopPlace, String shopTime, String shopLocation, String shopImg) {
        ShopImageId = shopImageId;
        this.shopTitle = shopTitle;
        this.shopRating = shopRating;
        this.shopPhone = shopPhone;
        this.shopPlace = shopPlace;
        this.shopTime = shopTime;
        this.shopLocation = shopLocation;
        this.shopImage = shopImg;
    }

    public Shop(int imageId, String title, float rating, String phone, String place, String time, String location) {
        this.ShopImageId = imageId;
        this.shopTitle = title;
        this.shopRating = rating;
        this.shopPhone = phone;
        this.shopPlace = place;
        this.shopTime = time;
        this.shopLocation = location;
    }

    public int getShopImageId() {
        return ShopImageId;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public float getShopRating() {
        return shopRating;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public String getShopPlace() {
        return shopPlace;
    }

    public String getShopTime() {
        return shopTime;
    }

    public String getShopLocation() {
        return shopLocation;
    }
}