package com.example.victoriabulson.financingapp;

/**
 * Setters and getters for the categories, locations, description for each expense
 */
class Transaction {

    private double price;
    private String description;
    private String location;
    private String category;

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
}
