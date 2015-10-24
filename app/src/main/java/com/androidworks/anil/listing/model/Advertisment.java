package com.androidworks.anil.listing.model;

/**
 Created by Anil Ugale on 16/10/2015.
 */
public class Advertisment {

    private String name;
    private String price;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
