package com.example.victoriabulson.financingapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddExpenseActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        Gson gson = new Gson();

        savedBudget = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        String json = savedBudget.getString("savedBudgetKey", null);
        Type type = new TypeToken<ArrayList<Expense>>() {
        }.getType();
        expenseList = gson.fromJson(json, type);

        Spinner spinner = (Spinner) findViewById(R.id.catagoryNameSpinner);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 11; i++){
            list.add(expenseList.get(i).getCategoryName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }
    public void buttonADD(View view) {

        EditText editValue = (EditText) findViewById(R.id.Amount);
        Spinner spinner = (Spinner)findViewById(R.id.catagoryNameSpinner);
        String category = spinner.getSelectedItem().toString();
        EditText editText = (EditText) findViewById(R.id.Description);
        String descpription = editText.getText().toString();
        double price;
        if(editValue.getText().toString().trim().length() > 0) {
            price = Double.parseDouble(editValue.getText().toString());
        }
        else{
            price = 0;
        }
        Transaction newItem = new Transaction(price, category, descpription);
        for(int i = 0; i < 11; i++){
            if(expenseList.get(i).getCategoryName() == category){
                    double total = price + expenseList.get(i).getSpent();
                    expenseList.get(i).setSpent(total);
                    expenseList.get(i).addArray(newItem);
            }
        }
        SharedPreferences.Editor preferencesEditor = savedBudget.edit();

        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey",expenseListString);
        preferencesEditor.apply();

        AddExpenseActivity.this.finish();
}
}
