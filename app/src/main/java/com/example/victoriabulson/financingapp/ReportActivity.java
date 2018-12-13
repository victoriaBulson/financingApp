package com.example.victoriabulson.financingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Runs the detailed view of the budget
 */
public class ReportActivity extends AppCompatActivity {

    public SharedPreferences savedBudget;
    public List<Expense> expenseList = new ArrayList<Expense>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Gson gson = new Gson();
        savedBudget = PreferenceManager.getDefaultSharedPreferences(this);
        String json = savedBudget.getString("savedBudgetKey", null);
        Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
        expenseList = gson.fromJson(json, type);


        //RENT
        TextView rentView = findViewById(R.id.rentSpent);
        rentView.setText("Spent: $" + expenseList.get(0).getSpent() + " Budget: $" + expenseList.get(0).getBudget());
        ProgressBar rentBar = findViewById(R.id.rentProgressBar);
        rentBar.setProgress(percentBudget(0));

        //FOOD
        TextView foodView = findViewById(R.id.foodSpent);
        foodView.setText("Spent: $" + expenseList.get(1).getSpent() + " Budget: $" + expenseList.get(1).getBudget());
        ProgressBar foodBar = findViewById(R.id.foodProgressBar);
        foodBar.setProgress(percentBudget(1));

        //TRANSPORTATION
        TextView transportView = findViewById(R.id.transportSpent);
        transportView.setText("Spent: $" + expenseList.get(2).getSpent() + " Budget: $" + expenseList.get(2).getBudget());
        ProgressBar transportBar = findViewById(R.id.transportProgressBar);
        transportBar.setProgress(percentBudget(2));

        //UTILITIES
        TextView utilitiesView = findViewById(R.id.utilitiesSpent);
        utilitiesView.setText("Spent: $" + expenseList.get(3).getSpent() + " Budget: $" + expenseList.get(3).getBudget());
        ProgressBar utilitiesBar = findViewById(R.id.utilitiesProgressBar);
        utilitiesBar.setProgress(percentBudget(3));

        //ENTERTAINMENT
        TextView entertainView = findViewById(R.id.entertainmentSpent);
        entertainView.setText("Spent: $" + expenseList.get(4).getSpent() + " Budget: $" + expenseList.get(4).getBudget());
        ProgressBar entertainBar = findViewById(R.id.entertainmentProgressBar);
        entertainBar.setProgress(percentBudget(4));

        //PERSONAL CARE
        TextView personalView = findViewById(R.id.personalSpent);
        personalView.setText("Spent: $" + expenseList.get(5).getSpent() + " Budget: $" + expenseList.get(5).getBudget());
        ProgressBar personalBar = findViewById(R.id.personalProgressBar);
        personalBar.setProgress(percentBudget(5));

        //HEALTH CARE
        TextView healthView = findViewById(R.id.healthSpent);
        healthView.setText("Spent: $" + expenseList.get(6).getSpent() + " Budget: $" + expenseList.get(6).getBudget());
        ProgressBar healthBar = findViewById(R.id.healthProgressBar);
        healthBar.setProgress(percentBudget(6));

        //EMERGENCY FUND
        TextView emergencyView = findViewById(R.id.emergencySpent);
        emergencyView.setText("Spent: $" + expenseList.get(7).getSpent() + " Budget: $" + expenseList.get(7).getBudget());
        ProgressBar emergencyBar = findViewById(R.id.emergencyProgressBar);
        emergencyBar.setProgress(percentBudget(7));

        //SAVINGS
        TextView savingsView = findViewById(R.id.savingSpent);
        savingsView.setText("Spent: $" + expenseList.get(8).getSpent() + " Budget: $" + expenseList.get(8).getBudget());
        ProgressBar savingsBar = findViewById(R.id.savingProgressBar);
        savingsBar.setProgress(percentBudget(8));

        //DEBT
        TextView debtView = findViewById(R.id.debtSpent);
        debtView.setText("Spent: $" + expenseList.get(9).getSpent() + " Budget: $" + expenseList.get(9).getBudget());
        ProgressBar debtBar = findViewById(R.id.debtProgressBar);
        debtBar.setProgress(percentBudget(9));

        //OTHER
        TextView otherView = findViewById(R.id.otherSpent);
        otherView.setText("Spent: $" + expenseList.get(10).getSpent() + " Budget: $" + expenseList.get(10).getBudget());
        ProgressBar otherBar = findViewById(R.id.otherProgressBar);
        otherBar.setProgress(percentBudget(10));
    }

    public void buttonClickClose(View view) {
        Intent plannerIntent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(plannerIntent);
    }

    public void buttonClickTransaction(View view, int x) {
        Intent plannerIntent = new Intent(ReportActivity.this, TransactionReport.class);
        plannerIntent.putExtra("bob", x);
        startActivity(plannerIntent);
    }

    public int percentBudget(int aval){
        return (int) ((expenseList.get(aval).getSpent() / expenseList.get(aval).getBudget())*100);
    }

    public void buttonRent(View view){
        buttonClickTransaction(view, 0);
    }
    public void buttonFood(View view){
        buttonClickTransaction(view, 1);
    }
    public void buttonTransportation(View view){
        buttonClickTransaction(view, 2);
    }
    public void buttonUtilies(View view){
        buttonClickTransaction(view, 3);
    }
    public void buttonEntertainment(View view){
        buttonClickTransaction(view, 4);
    }
    public void buttonPersonal(View view){
        buttonClickTransaction(view, 5);
    }
    public void buttonHealth(View view){
        buttonClickTransaction(view, 6);
    }
    public void buttonEmergency(View view){
        buttonClickTransaction(view, 7);
    }
    public void buttonSavings(View view){
        buttonClickTransaction(view, 8);
    }
    public void buttonDept(View view){
        buttonClickTransaction(view, 9);
    }
    public void buttonOther(View view){
        buttonClickTransaction(view, 10);
    }

}
