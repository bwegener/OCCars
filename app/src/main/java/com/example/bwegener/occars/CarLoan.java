package com.example.bwegener.occars;

/**
 * The Car Loan handles the price of the car, the down payment, the state tax,
 * the terms and then calculates them for the user.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9/14/2017.
 */

public class CarLoan {

    private double mPrice;
    private double mDownPayment;
    private static final double STATE_TAX = 0.08;
    private int mTerm;

    /**
     * This gets the price of the car.
     *
     * @return the price of the car.
     */
    public double getPrice()
    {
        return mPrice;
    }

    /**
     * This sets the price of the car from what the user has entered.
     *
     * @param carPrice this is the price of the car.
     */
    public void setPrice(double carPrice)
    {
        mPrice = carPrice;
    }

    /**
     * This gets the down payment for the car.
     *
     * @return the down payment of the car.
     */
    public double getDownPayment()
    {
        return mDownPayment;
    }

    /**
     * This sets the down payment, from what the user has entered.
     *
     * @param downPayment the downpayment for the car.
     */
    public void setDownPayment(double downPayment)
    {
        mDownPayment = downPayment;
    }

    public double getTerm()
    {
        return mTerm;
    }

    public void setTerm(int term)
    {
        mTerm = term;
    }


    public double taxAmount()
    {
        return mPrice * STATE_TAX;
    }

    public double totalAmount()
    {
        return mPrice + taxAmount();
    }

    public double borrowedAmount()
    {
        return mPrice - mDownPayment;
    }

    public double interestAmount()
    {
        /*
        3 year APR = 4.62%
        4 year APR = 4.19%
        5 year APR = 4.16%
         */
        double interestRate;
        switch(mTerm)
        {
            case 3:
                interestRate = 0.0462;
                break;
            case 4:
                interestRate = 0.0419;
                break;
            case 5:
                interestRate = 0.0416;
                break;
            default:
                // Should never be used
                interestRate = 0.10;
                break;
        }
        return borrowedAmount() * interestRate;
    }

    public double monthlyPayment()
    {
        return (borrowedAmount() + interestAmount()) / (mTerm * 12);
    }

}
