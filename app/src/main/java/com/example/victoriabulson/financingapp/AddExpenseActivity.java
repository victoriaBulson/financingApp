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
        String text = spinner.getSelectedItem().toString();
        for(int i = 0; i < 11; i++){
            if(expenseList.get(i).getCategoryName() == text){
                if(editValue.getText().toString().trim().length() > 0) {
                    double total = Double.parseDouble(editValue.getText().toString()) + expenseList.get(i).getSpent();
                    expenseList.get(i).setSpent(total);
                }
                else{
                    expenseList.get(i).setSpent(0);
                }
            }
        }
        SharedPreferences.Editor preferencesEditor = savedBudget.edit();

        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey",expenseListString);
        preferencesEditor.apply();
        Toast.makeText(this,expenseListString,Toast.LENGTH_SHORT).

        show();

        AddExpenseActivity.this.finish();
}
}
