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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionReport extends AppCompatActivity {

    LinearLayout linearLayout;
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);
    DateFormat dateFormat = new SimpleDateFormat("dd/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_report);
        int x = 1;
        // Getting the saved infomation so we can Display
        Gson gson = new Gson();
        savedBudget = PreferenceManager.getDefaultSharedPreferences(this);
        String json = savedBudget.getString("savedBudgetKey", null);
        Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
        expenseList = gson.fromJson(json, type);

        // Getting which Category is wanted to be displayed
        Intent intent = getIntent();
        int y = intent.getIntExtra("indexNum", x);
        linearLayout = findViewById(R.id.linear_layout);

        //Displays the title of the report
        TextView titleName = findViewById(R.id.titleDisplay);
        titleName.setText(expenseList.get(y).getCategoryName());

        // Moving the transaction array for the selected Item in to a new array
        List <Transaction> transactions = new ArrayList<Transaction>();
        transactions = expenseList.get(y).getArray();

        // Loops through the transaction area for the Category that is selected
        for (int i = 0; i < transactions.size(); i++){

            // Getting the Date to display correctly
            int month = transactions.get(i).getDate().getMonth();
            String strdate = String.valueOf(month + 1) + "/" + dateFormat.format(transactions.get(i).getDate());

            // Add the description to the Date
            strdate += " - " + transactions.get(i).getDescription();

            // Displaying the Date and Description
            TextView date = new TextView(this);
            date.setText(strdate);
            date.setTextSize(18);
            date.setLayoutParams(params);
            date.setPadding(100,0,0,0);
            linearLayout.addView(date);

            // Displaying the Amount spent on the transaction
            TextView price = new TextView(this);
            price.setText("$" + String.format("%.02f",transactions.get(i).getPrice()));
            price.setLayoutParams(params);
            price.setPadding(100,0,0,50);
            linearLayout.addView(price);
        }
    }

    // Closing the Activity
    public void buttonClickClose(View view) {
        TransactionReport.this.finish();
    }
}
