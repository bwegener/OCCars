package com.example.bwegener.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DecimalFormat;

/**
 * The PurchaseActivity is where all of the activities from the CarLoan
 * are being connected to the user input in the activity_purchase.
 *
 * @author Brian Wegener
 * @version 1.0
 *          <p>
 *          Created on 9.14.2017
 */
public class PurchaseActivity extends AppCompatActivity {

    DecimalFormat hundredDP = new DecimalFormat("#.00");

    // Connections to VIEW
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    // Connection to the MODEL
    private CarLoan mCarLoan = new CarLoan();


    /**
     * This is where the user's input is connected to the car loan.
     *
     * @param savedInstanceState this is what happens every time the app is loaded
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // I made a comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        // Use
        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

    }

    private void collectCarLoanData() {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if (mFourYearRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);
    }

    /**
     * This helps connect the button on the activity_purchase to an action
     * which allows the user to see a new screen with all relevant information
     * displayed.
     *
     * @param v creates a new view
     */
    protected void reportSummary(View v) {

        collectCarLoanData();
        String report = "   Monthly Payment: $" + hundredDP.format(mCarLoan.monthlyPayment()) +
                "\n\n  Car Sticker Price: $    " + hundredDP.format(mCarLoan.getPrice()) +
                "\n  You will put down: $    " + hundredDP.format(mCarLoan.getDownPayment()) +
                "\n  Taxed Amt: $             " + hundredDP.format(mCarLoan.taxAmount()) +
                "\n  Your Cost: $            " + hundredDP.format(mCarLoan.totalAmount()) +
                "\n  Borrowed Amount: $      " + hundredDP.format(mCarLoan.borrowedAmount()) +
                "\n  Interest Amount: $       " + hundredDP.format(mCarLoan.interestAmount()) +
                "\n\n  Loan Term is " + Math.round(mCarLoan.getTerm()) + " years." +
                "\n\n NOTE:" +
                "\n\n 1. Loan information is made available by OC Cars." +
                "\n\n 2. A sales tax rate of 8% is required in Costa Mesa." +
                "\n\n 3. Vehicles are financed at an annual interest rate of 9%.";

        // Intents start new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);

        // Put data into the Intent for Loan Summary to receive
        launchLoanSummary.putExtra("loanReport", report);

        // Start the second activity
        startActivity(launchLoanSummary);
    }
}
