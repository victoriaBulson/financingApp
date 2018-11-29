package com.example.victoriabulson.financingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

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
        expenseList = gson.fromJson(json, List.class);

    }

    public void buttonClick(View view) {
        Intent plannerIntent = new Intent(BudgetPlanningActivity.this, MainActivity.class);

    }

    public void buttonSave(View view) {

        /*expenseList.get(0).setBudget(Double.parseDouble(toString(getText(R.id.rentMoney))));
        expenseList.get(1).setBudget(R.id.foodMoney);
        expenseList.get(2).setBudget(R.id.transportationMoney);
        expenseList.get(3).setBudget(R.id.utilitesMoney);
        expenseList.get(4).setBudget(R.id.entertainmentMoney);
        expenseList.get(5).setBudget(R.id.personalMoney);
        expenseList.get(6).setBudget(R.id.healthMoney);
        expenseList.get(7).setBudget(R.id.emergencyMoney);
        expenseList.get(8).setBudget(R.id.savingsMoney);
        expenseList.get(9).setBudget(R.id.debtMoney);
        expenseList.get(10).setBudget(R.id.otherMoney);

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
        checkBox = (CheckBox) findViewById(R.id.rentCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(0).setFixed(true);
        } else {
            expenseList.get(0).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.foodCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(1).setFixed(true);
        } else {
            expenseList.get(1).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.transportationCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(2).setFixed(true);
        } else {
            expenseList.get(2).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.utilitiesCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(3).setFixed(true);
        } else {
            expenseList.get(3).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.entertainCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(4).setFixed(true);
        } else {
            expenseList.get(4).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.personalCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(5).setFixed(true);
        } else {
            expenseList.get(5).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.healthCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(6).setFixed(true);
        } else {
            expenseList.get(6).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.emergencyCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(7).setFixed(true);
        } else {
            expenseList.get(7).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.savingCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(8).setFixed(true);
        } else {
            expenseList.get(8).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.debtCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(9).setFixed(true);
        } else {
            expenseList.get(9).setFixed(false);
        }

        checkBox = (CheckBox) findViewById(R.id.otherCheckBoxA);
        if (checkBox.isChecked()) {
            expenseList.get(10).setFixed(true);
        } else {
            expenseList.get(10).setFixed(false);
        }*/
        SharedPreferences.Editor preferencesEditor = savedBudget.edit();

        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey", expenseListString);
        preferencesEditor.commit();
        Toast.makeText(this, expenseListString,Toast.LENGTH_SHORT).show();

        BudgetPlanningActivity.this.finish();
    }
}

