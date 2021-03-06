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

        //EditText editValue = (EditText) findViewById(R.id.rentMoney);
       //editValue.setText(Double.toString(expenseList.get(0).getBudget()));
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
        // If fixed amount checkbox
        CheckBox checkBox = (CheckBox) findViewById(R.id.rentCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(0).setFixed(true);
        } else {
            expenseList.get(0).setFixed(false);
        }
        checkBox = (CheckBox) findViewById(R.id.foodCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(1).setFixed(true);
        } else {
            expenseList.get(1).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.transportationCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(2).setFixed(true);
        } else {
            expenseList.get(2).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.utilitiesCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(3).setFixed(true);
        } else {
            expenseList.get(3).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.entertainCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(4).setFixed(true);
        } else {
            expenseList.get(4).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.personalCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(5).setFixed(true);
        } else {
            expenseList.get(5).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.healthCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(6).setFixed(true);
        } else {
            expenseList.get(6).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.emergencyCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(7).setFixed(true);
        } else {
            expenseList.get(7).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.savingCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(8).setFixed(true);
        } else {
            expenseList.get(8).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.debtCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(9).setFixed(true);
        } else {
            expenseList.get(9).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.otherCheckBoxF);
        if (checkBox.isChecked()) {
            expenseList.get(10).setFixed(true);
        } else {
            expenseList.get(10).setFixed(false);
        }
        // If in used checkboxs
        checkBox = (CheckBox) findViewById(R.id.rentCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(0).setUsed(true);
        } else {
            expenseList.get(0).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.foodCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(1).setUsed(true);
        } else {
            expenseList.get(1).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.transportationCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(2).setUsed(true);
        } else {
            expenseList.get(2).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.utilitiesCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(3).setUsed(true);
        } else {
            expenseList.get(3).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.entertainCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(4).setUsed(true);
        } else {
            expenseList.get(4).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.personalCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(5).setUsed(true);
        } else {
            expenseList.get(5).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.healthCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(6).setUsed(true);
        } else {
            expenseList.get(6).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.emergencyCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(7).setUsed(true);
        } else {
            expenseList.get(7).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.savingCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(8).setUsed(true);
        } else {
            expenseList.get(8).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.debtCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(9).setUsed(true);
        } else {
            expenseList.get(9).setUsed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.otherCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(10).setUsed(true);
        } else {
            expenseList.get(10).setUsed(false);
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

