package com.example.victoriabulson.financingapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TransactionTest {
    @Test
    public void test_price() {
        Transaction thingBought  = new Transaction();
        //TEST PRICE
        thingBought.setPrice(20);
        assert (20 == thingBought.getPrice());
    }

    @Test
    public void test_location() {
        Transaction thingBought  = new Transaction();
        //TEST LOCATION
        thingBought.setLocation("wall-mart");
        assert ("wall-mart" == thingBought.getLocation());
    }

    @Test
    public void test_category() {
        Transaction thingBought  = new Transaction();
        //TEST CATEGORY
        thingBought.setCategory("grocery");
        assert ("grocery" == thingBought.getCategory());
    }

    @Test
    public void test_description() {
        Transaction thingBought  = new Transaction();
        //TEST DESCRIPTION
        thingBought.setDescription("Bought a bagel");
        assert ("Bought a bagel" == thingBought.getDescription());
    }
}
