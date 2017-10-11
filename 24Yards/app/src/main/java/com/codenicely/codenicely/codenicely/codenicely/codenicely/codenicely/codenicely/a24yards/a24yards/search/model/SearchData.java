package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model;

/**
 * Created by vrihas on 10/10/17.
 */

public class SearchData {

    String title;
    String location;
    int bhk;
    String description;
    String price;
    String contact;
    String usage;
    String date_added;
    String image;

    public SearchData(String title, String location, int bhk, String description, String price, String contact, String usage, String date_added, String image) {
        this.title = title;
        this.location = location;
        this.bhk = bhk;
        this.description = description;
        this.price = price;
        this.contact = contact;
        this.usage = usage;
        this.date_added = date_added;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getBhk() {
        return bhk;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getContact() {
        return contact;
    }

    public String getUsage() {
        return usage;
    }

    public String getDate_added() {
        return date_added;
    }

    public String getImage() {
        return image;
    }
}
