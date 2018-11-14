package com.example.victoriabulson.financingapp;

class Expense {

    private String categoryName;
    private double budget;
    private double spent;
    private boolean fixed;
    private boolean beingUsed;

    public Expense(){
        categoryName = null;
        budget = 0;
        spent = 0;
        fixed = false;
        beingUsed = true;
    }


    public Expense(String category){
        setCategoryName(category);
        budget = 0;
        spent = 0;
        fixed = false;
        beingUsed = true;
    }


    private void setUsed(boolean isUsed) {
        beingUsed = isUsed;
    }

    private boolean getUsed() {
        return beingUsed;
    }

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
