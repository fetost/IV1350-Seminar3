package se.kth.iv1350.model;

/**
  The Payment class represents a payment made by the customer during a sale.
  It contains information about the amount paid, the running total and the change returned.
 */
public class Payment {
    
    private double paidAmount; // The amount paid by the customer.
    private double runningTotal; // The running total of the sale.
    private double change; // The change to be returned to the customer.

    /**
     Creates a new instance of Payment with the specified paid amount and running total.
      @param paidAmount The amount paid by the customer.
      @param runningTotal The running total of the sale.
     */
    public Payment(double paidAmount, double runningTotal){
        this.paidAmount = paidAmount; 
        this.runningTotal = runningTotal;
    }
    /**
      Gets the amount paid by the customer.
      @return The amount paid by the customer.
     */
    public double getPaidAmount(){
        return paidAmount;
    }

    /**
      Gets the running total of the sale.
      @return The running total of the sale.
     */
    public double getRunningTotal(){
        return runningTotal; 
    }

    /**
      Calculates and returns the change to be returned to the customer.
      @return The change to be returned to the customer.
     */
    public double getChange(){
        change = paidAmount - runningTotal; 
        return change;  
    }
}
