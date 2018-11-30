package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Runs the detailed view of the budget
 */
public class ReportActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Gson gson = new Gson();
        savedBudget = PreferenceManager.getDefaultSharedPreferences(this);
        String json = savedBudget.getString("savedBudgetKey", null);
        Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
        expenseList = gson.fromJson(json, type);
    }

    public void buttonClickClose(View view) {
        Intent plannerIntent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(plannerIntent);
    }


}
