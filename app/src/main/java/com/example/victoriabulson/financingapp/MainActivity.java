package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);
    public Expense thing;

    @Override
    /**
     * Generates the array if nonexistent and pulls it if it does exist
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    /**
     * Saves the array when the app is closed
     */
    protected void onPause() {
        super.onPause();

        //savedBudget = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = savedBudget.edit();

        Gson gson = new Gson();
        String expenseListString = gson.toJson(expenseList);
        preferencesEditor.putString("savedBudgetKey", expenseListString);
        preferencesEditor.apply();

        //PRINTS SAVED STRING
        String json = savedBudget.getString("savedBudgetKey", null);
        //Expense zero = expenseList.get(0);
        //double zeroMoney = zero.getBudget();

        //Log.d("onPause", String.valueOf(testBudg));

    }

    @Override
    protected void onResume(){
        super.onResume();

        Gson gson = new Gson();


        savedBudget = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        String json = savedBudget.getString("savedBudgetKey", null);

        //PRINTS PULLED STRING

        if (json == null) {                                                 //json never evaluates as null (11/14)

            createStorage();
            Log.i("MAIN_ACT", "json == null");
            //Toast.makeText(this,"Created new array",Toast.LENGTH_SHORT).show();
        }
        else {
            Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
            expenseList = gson.fromJson(json, type);
            Log.i("MAIN", "json != null");
        }

        //expenseList = gson.fromJson(json, type);
        Log.i("MAIN", "json != null");
        double totalbudget = 0;
        TextView tv = (TextView)findViewById(R.id.budgetDisplay);
        for (int i = 0; i <11; i++){
          double budget = expenseList.get(i).getBudget();
          double old = totalbudget;
          totalbudget = old + budget;
        }
        tv.setText(String.format("%.02f",totalbudget));
        double totalSpent = 0;
        TextView ts = (TextView)findViewById(R.id.spentDisplay);
        for (int i = 0; i <11; i++){
            double budget = expenseList.get(i).getSpent();
            double old = totalSpent;
            totalSpent = old + budget;
        }
        ts.setText(String.format("%.02f",totalSpent));

        Double spentProgress = (totalSpent/totalbudget) * 100;
        ProgressBar spentProgressDisplay = findViewById(R.id.budgProgBar);
        spentProgressDisplay.setProgress(spentProgress.intValue());

    }

    /**
     * Opens the budget planning activity for the viewer to see
     * @param view
     */
    public void buttonClick(View view) {
        Intent plannerIntent = new Intent(MainActivity.this, BudgetPlanningActivity.class);
        startActivity(plannerIntent);
    }

    /**
     * Creates the storage to hold the variables
     */
    private void createStorage(){


        thing = new Expense("thing");


        Expense rentObject = new Expense(getString(R.string.Rent));
        expenseList.add(rentObject);
        Expense foodObject = new Expense(getString(R.string.Food));
        expenseList.add(foodObject);
        Expense transportObject = new Expense(getString(R.string.Transportation));
        expenseList.add(transportObject);
        Expense utilitiesObject = new Expense(getString(R.string.Utilities));
        expenseList.add(utilitiesObject);
        Expense entertainmentObject = new Expense(getString(R.string.Entertainment));
        expenseList.add(entertainmentObject);
        Expense personalCareObject = new Expense(getString(R.string.PersonalCare));
        expenseList.add(personalCareObject);
        Expense healthCareObject = new Expense(getString(R.string.HealthCare));
        expenseList.add(healthCareObject);
        Expense emergencyFundObject = new Expense(getString(R.string.EmergencyFund));
        expenseList.add(emergencyFundObject);
        Expense savingsObject = new Expense(getString(R.string.Savings));
        expenseList.add(savingsObject);
        Expense debtObject = new Expense(getString(R.string.Debt));
        expenseList.add(debtObject);
        Expense otherObject = new Expense(getString(R.string.Other));
        expenseList.add(otherObject);

        expenseList.get(0);

    }


    public void buttonClickReport(View view) {
        Intent plannerIntent = new Intent(MainActivity.this, ReportActivity.class);
        startActivity(plannerIntent);
    }

    public void buttonAddExpense(View view) {
        Intent plannerIntent = new Intent(MainActivity.this, AddExpenseActivity.class);
        startActivity(plannerIntent);
    }

    public void buttonResetSpent(View view) {
        for(int i = 0; i < 11; i++){
            expenseList.get(i).setSpent(0);
        }

        TextView ts = (TextView)findViewById(R.id.spentDisplay);
        ts.setText("0.00");
        ProgressBar spentProgressDisplay = findViewById(R.id.budgProgBar);
        int zero = 0;
        spentProgressDisplay.setProgress(zero);
        }


}
