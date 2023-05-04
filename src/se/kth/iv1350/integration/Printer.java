package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;

/** 
 * Creates the class Printer
 */
public class Printer {

    /**
     * Creates an instance of Printer.
     */
    public Printer(){
    }

    /**
     * A receipt is printed at the end of the sale.
     * @param receipt Holds all of the sale information, in other words the SaleDTO.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.createReceipt()); 
    }
}
