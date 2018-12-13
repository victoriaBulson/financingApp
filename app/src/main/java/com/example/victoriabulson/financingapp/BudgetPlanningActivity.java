package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BudgetPlanningActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_planning);
        Gson gson = new Gson();
        savedBudget  = PreferenceManager.getDefaultSharedPreferences(this);
        String json = savedBudget.getString("savedBudgetKey", null);
        Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
        expenseList = gson.fromJson(json, type);
        Log.i("MAIN", "json != null");

        EditText editValue = (EditText) findViewById(R.id.rentMoney);
        editValue.setText(Double.toString(expenseList.get(0).getBudget()));
        editValue = (EditText) findViewById(R.id.foodMoney);
        editValue.setText(Double.toString(expenseList.get(1).getBudget()));
        editValue = (EditText) findViewById(R.id.transportationMoney);
        editValue.setText(Double.toString(expenseList.get(2).getBudget()));
        editValue = (EditText) findViewById(R.id.utilitesMoney);
        editValue.setText(Double.toString(expenseList.get(3).getBudget()));
        editValue = (EditText) findViewById(R.id.entertainmentMoney);
        editValue.setText(Double.toString(expenseList.get(4).getBudget()));
        editValue = (EditText) findViewById(R.id.personalMoney);
        editValue.setText(Double.toString(expenseList.get(5).getBudget()));
        editValue = (EditText) findViewById(R.id.healthMoney);
        editValue.setText(Double.toString(expenseList.get(6).getBudget()));
        editValue = (EditText) findViewById(R.id.emergencyMoney);
        editValue.setText(Double.toString(expenseList.get(7).getBudget()));
        editValue = (EditText) findViewById(R.id.savingsMoney);
        editValue.setText(Double.toString(expenseList.get(8).getBudget()));
        editValue = (EditText) findViewById(R.id.debtMoney);
        editValue.setText(Double.toString(expenseList.get(9).getBudget()));
        editValue = (EditText) findViewById(R.id.otherMoney);
        editValue.setText(Double.toString(expenseList.get(10).getBudget()));
    }


    public void buttonClick(View view) {
        Intent plannerIntent = new Intent(BudgetPlanningActivity.this, MainActivity.class);

    }

     public void buttonSave(View view) {

        EditText editValue = (EditText) findViewById(R.id.rentMoney);
        Log.d("onSaved", editValue.getText().toString());
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(0).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(0).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.foodMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(1).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(1).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.transportationMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(2).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(2).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.utilitesMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(3).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(3).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.entertainmentMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(4).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(4).setBudget(0);
        };
        editValue = (EditText) findViewById(R.id.personalMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(5).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(5).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.healthMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(6).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(6).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.emergencyMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(7).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(7).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.savingsMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(8).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(8).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.debtMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(9).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(9).setBudget(0);
        }
        editValue = (EditText) findViewById(R.id.otherMoney);
        if(editValue.getText().toString().trim().length() > 0) {
            expenseList.get(10).setBudget(Double.parseDouble(editValue.getText().toString()));
        }
        else{
            expenseList.get(10).setBudget(0);
        }

        SharedPreferences.Editor preferencesEditor = savedBudget.edit();

        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey", expenseListString);
        preferencesEditor.apply();
        //Toast.makeText(this, expenseListString,Toast.LENGTH_SHORT).show();

        BudgetPlanningActivity.this.finish();
    }
}

