package se.kth.iv1350.integration;

/**
ExternalAccounting represents an external accounting system that keeps track of the store's balance.
 */
public class ExternalAccounting {
    private double accountingBalance;

    /**
     *Creates a new instance of ExternalAccounting with an initial balance of 500.
     */
    public ExternalAccounting(){
        this.accountingBalance = 500;
    }

    /**
    *Retrieves the current balance of the external accounting system.
    *@return the current accounting balance
    */
    public double getInitialBalance(){
        return this.accountingBalance;
    }

    /**
     *Updates the accounting balance by adding the paid amount.
     *@param paidAmount the amount paid in the sale
     */
    public void updateAccounting(double paidAmount){
        this.accountingBalance += paidAmount;
    }
}
