package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BudgetPlanningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_planning);
        }
    public void buttonClick(View view){
        Intent plannerIntent = new Intent(BudgetPlanningActivity.this, MainActivity.class);

    }
}
