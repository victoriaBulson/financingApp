package com.example.victoriabulson.financingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public String sharedPrefFile = "savedBudget";
    public List<Expense> expenseList = new ArrayList<>(11);
    public String initialized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        savedBudget = getPreferences(Context.MODE_PRIVATE);
        String json = savedBudget.getString("savedBudgetKey", null);
        initialized = savedBudget.getString("initializedKey", null);
            //PRINTS PULLED STRING
         final String TAG = "MAIN_ACTIVITY";
          //Log.d(TAG, "JSON IS: ");
          //Log.d(TAG, json);                   //Json always prints as null (11/14)
        //Log.d(TAG, empty);

        Toast printSavedMain = Toast.makeText(getApplicationContext(),
              json,
              Toast.LENGTH_LONG);

        printSavedMain.show();

        if (initialized == null) {                                                 //json never evaluates as null (11/14)
          //Log.d(TAG, "IF");
            Toast ifEntered = Toast.makeText(getApplicationContext(),
                    json,
                    Toast.LENGTH_LONG);
            ifEntered.show();
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
          savedBudget = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
          initialized = "DONE!";
        }
        else {
          expenseList = gson.fromJson(json, List.class);
          //Log.d(TAG, "ELSE");
            Toast ElseEntered = Toast.makeText(getApplicationContext(),
                    "ELSE STATEMENT",
                    Toast.LENGTH_LONG);
            ElseEntered.show();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = savedBudget.edit();
        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey", expenseListString);
        preferencesEditor.putString("initializedKey", initialized);
        preferencesEditor.commit();
        final String TAG = "MAIN_ACTIVITY";
        //PRINTS SAVED STRING
            String json = savedBudget.getString("savedBudgetKey", null);
            //Log.d(TAG, "THIS WAS SAVED: ");
            //Log.d(TAG, json);
             Toast printSavedPause = Toast.makeText(getApplicationContext(),
              json,
              Toast.LENGTH_LONG);

            printSavedPause.show();



    }

    public void buttonClick(View view){
        Intent plannerIntent = new Intent(MainActivity.this, BudgetPlanning.class);
        startActivity(plannerIntent);
    }
}
