package com.example.victoriabulson.financingapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Setters and getters for the categories, locations, description for each expense
 */
class Transaction {

    // Declares all the different variables
    private double price;
    private String description;
    private String location;
    private String category;
    private Date date;

    // Creates a transaction object
    Transaction(double newPrice, String newCategory, String newDescription){
        price = newPrice;
        category = newCategory;
        description = newDescription;
        date = new Date();
    }

    // Declares all the setters and getters for the function
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDate(Date date){ this.date = date; }

    public Date getDate(){ return date; }
}
