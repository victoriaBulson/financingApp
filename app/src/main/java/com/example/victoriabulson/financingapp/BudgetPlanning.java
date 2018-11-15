package com.example.victoriabulson.financingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

public class BudgetPlanning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_planning);
        }
    public void buttonClick(View view){
        Intent plannerIntent = new Intent(BudgetPlanning.this, MainActivity.class);

    }
}
