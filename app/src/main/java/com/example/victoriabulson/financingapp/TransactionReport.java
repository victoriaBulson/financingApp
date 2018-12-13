package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionReport extends AppCompatActivity {

    LinearLayout linearLayout;
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);
    DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");

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
        int y = intent.getIntExtra("indexNum", x);

        linearLayout = findViewById(R.id.linear_layout);
        List <Transaction> transactions = new ArrayList<Transaction>();
        transactions = expenseList.get(y).getArray();
        for (int i = 0; i < transactions.size(); i++){
            String strdate = dateFormat.format(transactions.get(i).getDate());
            strdate += " " + transactions.get(i).getDescription();
            TextView date = new TextView(this);
            date.setText(strdate);
            date.setLayoutParams(params);
            date.setPadding(100,0,0,0);
            linearLayout.addView(date);
            TextView price = new TextView(this);
            price.setText(Double.toString(transactions.get(i).getPrice()));
            price.setLayoutParams(params);
            price.setPadding(100,0,0,50);
            linearLayout.addView(price);
        }
    }
    public void buttonClickClose(View view) {
        TransactionReport.this.finish();
    }
}
