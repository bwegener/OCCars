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
     * @param downPayment the down payment for the car.
     */
    public void setDownPayment(double downPayment)
    {
        mDownPayment = downPayment;
    }

    /**
     * This gets the term for the car loan.
     *
     * @return the term of the car loan.
     */
    public double getTerm()
    {
        return mTerm;
    }

    /**
     * This sets the term for the car loan from what the user has chosen.
     *
     * @param term the term for the car loan.
     */
    public void setTerm(int term)
    {
        mTerm = term;
    }

    /**
     * This finds the tax amount for the car.
     *
     * @return the tax amount.
     */
    public double taxAmount()
    {
        return mPrice * STATE_TAX;
    }

    /**
     * This gets the total amount for the car.
     *
     * @return the total amount for the car.
     */
    public double totalAmount()
    {
        return mPrice + taxAmount();
    }

    /**
     * This gets the borrowed amount for the car.
     *
     * @return the borrowed amount for the car.
     */
    public double borrowedAmount()
    {
        return totalAmount() - mDownPayment;
    }

    /**
     * This gets the interest amount for the car.
     *
     * @return the interest amount for the car.
     */
    public double interestAmount()
    {
        return mTerm * 12 * monthlyPayment() - borrowedAmount();
    }

    /**
     * This gets the monthly payment for the car.
     *
     * @return the monthly payment for the car.
     */
    public double monthlyPayment()
    {
        double monthlyInterestRate = 0.0;

        switch (mTerm)
        {
            case 3:
                monthlyInterestRate = 0.0462 / 12;
                break;
            case 4:
                monthlyInterestRate = 0.0419 / 12;
                break;
            case 5:
                monthlyInterestRate = 0.0416 / 12;
                break;
            default:
                monthlyInterestRate = 10;
                break;
                // This should not happen
        }

        double interestExpression = Math.pow(1 + monthlyInterestRate, mTerm * 12.0);

        return borrowedAmount() * monthlyInterestRate * interestExpression / (interestExpression - 1);
    }

}
