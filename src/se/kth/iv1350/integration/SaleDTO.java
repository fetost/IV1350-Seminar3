package se.kth.iv1350.integration;

import java.util.*;
import java.time.*;
/**
  SaleDTO, Sale data transfer object.
 */
public class SaleDTO {
    private java.time.LocalDateTime dateAndTime; 
    private double runningTotal;
    private double addedVAT;  
    private List<Item> items; 
    

    /**
      Creates an instance of SaleDTO.
      @param dateAndTime Current Date and Time of sale 
      @param runningTotal Price of sale before VAT and Discount
      @param addedVAT Holds the appropriate tax rate applied to the sale 
      @param items Holds all of the scanned items in the sale 
     */
    public SaleDTO (LocalDateTime dateAndTime, double runningTotal, double addedVAT, List<Item> items){
        this.dateAndTime = dateAndTime; 
        this.runningTotal = runningTotal;
        this.addedVAT = addedVAT; 
        this.items = items;
    }

    /**
      Returns Date and Time of sale
      @return dateAndTime, returns the local time
     */
    public java.time.LocalDateTime getDateAndTime(){
        return this.dateAndTime; 
    }

    /**
      Returns the total price before VAT and discount
      @return runningTotal 
     */
    public double getRunningTotal(){
        return this.runningTotal; 
    }

    /**
      Returns VAT tax rate for the entire sale
      @return VAT 
     */
    public double getAddedVAT(){
        return this.addedVAT; 
    }

    /**
     * Creates a list to gather all of the requested items. 
     * @return The list of requested items constantly updated throughout the sale.
     */
    public List<Item> getItems(){
        return this.items;
    }
}
