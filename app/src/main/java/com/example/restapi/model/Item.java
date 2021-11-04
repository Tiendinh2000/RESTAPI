package com.example.restapi.model;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("item_id")
    private int id;

    @SerializedName("name")
    private  String name;

    @SerializedName("price")
    private int price;

    @SerializedName("user")
    private User user;

    @SerializedName("category")
    private Category category;

    public Item(int id, String name, int price, User user,Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.user = user;
        this.category= category;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
