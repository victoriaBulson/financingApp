package com.example.victoriabulson.financingapp;

class Expense {

    private String categoryName;
    private double budget = 0;
    private double spent = 0;
    private boolean fixed = false;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }

    public double getSpent() {
        return spent;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean getFixed() {
        return fixed;
    }
}
