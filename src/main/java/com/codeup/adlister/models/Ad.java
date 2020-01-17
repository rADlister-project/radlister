package com.codeup.adlister.models;


import java.math.BigDecimal;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private int price;
    private String description;

    public Ad(long id, long userId, String title, int price, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Ad(long userId, String title, int price, String description) {

        this.userId = userId;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



    public void setPrice(int price) { this.price = price; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
