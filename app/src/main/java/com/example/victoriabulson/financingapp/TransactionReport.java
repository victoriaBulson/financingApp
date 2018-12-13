package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TransactionReport extends AppCompatActivity {

    LinearLayout linearLayout;
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_report);
        int x = 1;
        Gson gson = new Gson();
        savedBudget = PreferenceManager.getDefaultSharedPreferences(this);
        String json = savedBudget.getString("savedBudgetKey", null);
        Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
        expenseList = gson.fromJson(json, type);

        Intent intent = getIntent();
        int y = intent.getIntExtra("bob", x);

        linearLayout = findViewById(R.id.linear_layout);

        for (int i = 1; i <= 2; i++){
            TextView date = new TextView(this);
            date.setText(String.valueOf(y));
            date.setLayoutParams(params);
            date.setPadding(100,0,0,0);
            linearLayout.addView(date);
            TextView price = new TextView(this);
            price.setText("From the Other Side");
            price.setLayoutParams(params);
            price.setPadding(100,0,0,50);
            linearLayout.addView(price);
        }
    }
}
