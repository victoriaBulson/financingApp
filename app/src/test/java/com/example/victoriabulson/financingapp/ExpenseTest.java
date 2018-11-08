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
    public void test_expense(){
        Expense rentObject = new Expense();
        //TEST CATEGORY NAME
        rentObject.setCategoryName("rent");
        assert("rent" == rentObject.getCategoryName());

    }


}