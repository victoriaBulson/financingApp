package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<>(11);


    @Override
    /**
     * Generates the array if nonexistent and pulls it if it does exist
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();


        savedBudget = PreferenceManager.getDefaultSharedPreferences(this);

        String json = savedBudget.getString("savedBudgetKey", null);

        //PRINTS PULLED STRING

        if (json == null) {                                                 //json never evaluates as null (11/14)

            createStorage();
            Log.i("MAIN_ACT", "json == null");
            Toast.makeText(this,"Created new array",Toast.LENGTH_SHORT).show();
        }
        else {
            expenseList = gson.fromJson(json, List.class);
            Log.i("MAIN", "json != null");
    }


    }

    @Override
    /**
     * Saves the array when the app is closed
     */
    protected void onPause() {
        super.onPause();


        //savedBudget = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = savedBudget.edit();

        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey", expenseListString);
        preferencesEditor.apply();

        //PRINTS SAVED STRING
        String json = savedBudget.getString("savedBudgetKey", null);

    }

    /**
     * Opens the budget planning activity for the viewer to see
     * @param view
     */
    public void buttonClick(View view) {
        Intent plannerIntent = new Intent(MainActivity.this, BudgetPlanningActivity.class);
        startActivity(plannerIntent);
    }

    /**
     * Creates the storage to hold the variables
     */
    private void createStorage(){

        Expense rentObject = new Expense(getString(R.string.Rent));
        expenseList.add(rentObject);
        Expense transportObject = new Expense(getString(R.string.Transportation));
        expenseList.add(transportObject);
        Expense foodObject = new Expense(getString(R.string.Food));
        expenseList.add(foodObject);
        Expense utilitiesObject = new Expense(getString(R.string.Utilities));
        expenseList.add(utilitiesObject);
        Expense entertainmentObject = new Expense(getString(R.string.Entertainment));
        expenseList.add(entertainmentObject);
        Expense savingsObject = new Expense(getString(R.string.Savings));
        expenseList.add(savingsObject);
        Expense emergencyFundObject = new Expense(getString(R.string.EmergencyFund));
        expenseList.add(emergencyFundObject);
        Expense personalCareObject = new Expense(getString(R.string.PersonalCare));
        expenseList.add(personalCareObject);
        Expense healthCareObject = new Expense(getString(R.string.HealthCare));
        expenseList.add(healthCareObject);
        Expense debtObject = new Expense(getString(R.string.Debt));
        expenseList.add(debtObject);
        Expense otherObject = new Expense(getString(R.string.Other));
        expenseList.add(otherObject);

    }

}
