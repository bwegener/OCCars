package com.example.bwegener.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

/**
 * The Loan Summary Activity is where the calculations are shown to the user from
 * the previous activity.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9.14.2017
 */
public class LoanSummaryActivity extends AppCompatActivity {

    private TextView mLoanReport;

    /**
     * The app collects the user input from the previous screen and
     * forms the calculations and displays them here.
     *
     * @param savedInstanceState this is what happens when the app first starts
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Receive the Intent (from PurchaseActivity)
        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("loanReport");

        // Populate the text view with data
        mLoanReport = (TextView) findViewById(R.id.loanReportTextView);


        // Fill your TextView with data from the report
        mLoanReport.setText(report);
    }

    /**
     * This connects the return to data button to allow the user to return
     * to the screen where they entered the car price, down payment, and
     * loan terms.
     *
     * @param v this sends the user back to the purchase activity view
     */
    protected void goToPurchase(View v)
    {
        Intent intentFromPurchase = new Intent(this, PurchaseActivity.class);
        startActivity(intentFromPurchase);
    }
}
