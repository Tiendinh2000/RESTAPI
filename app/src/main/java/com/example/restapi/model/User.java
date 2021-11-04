package com.example.restapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {

    @SerializedName("user_id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("itemList")
    private List<Item> itemsList;

    @SerializedName("roles")
    private Collection<Role> roles = new ArrayList<>();

    public User(int id, String username, String password, List<Item> list, Collection<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.itemsList = list;
        this.roles= roles;
    }
    public User(String username, String password, List<Item> list, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.itemsList = list;
        this.roles= roles;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", itemsList=" + itemsList +
                '}';
    }
}
