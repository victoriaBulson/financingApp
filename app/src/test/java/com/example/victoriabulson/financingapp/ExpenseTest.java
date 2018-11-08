package com.example.victoriabulson.financingapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExpenseTest {
    @Test
    public void test_category_name(){
        Expense rentObject = new Expense();
        //TEST CATEGORY NAME
        rentObject.setCategoryName("rent");
        assert("rent" == rentObject.getCategoryName());
    }

    @Test
    public void test_budget(){
        Expense rentObject = new Expense();
        //TEST CATEGORY NAME
        rentObject.setBudget(1000);
        assert(1000 == rentObject.getBudget());
    }

    @Test
    public void test_spent(){
        Expense rentObject = new Expense();
        //TEST CATEGORY NAME
        rentObject.setSpent(500);
        assert(500 == rentObject.getSpent());
    }

    @Test
    public void test_fixed(){
        Expense rentObject = new Expense();
        //TEST CATEGORY NAME
        rentObject.setFixed(true);
        assert(true == rentObject.getFixed());
    }




}