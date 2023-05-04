package se.kth.iv1350.controller;

import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*; 

/**
 * Creates the controller class. 
 */
public class controller {
    private Sale sale; 
    private ExternalInventory extInv;
    private ExternalAccounting extAcc;
    private Printer printer; 
    
    /**
     * Creates an instance of controller
     * @param extInv Refers to the External Inventory Handler, to access the store's inventory.
     * @param extAcc Refers to the External Accounting Handler. to update the sale information.
     * @param printer To be able to print out the receipt at the end of the sale.
     */
    public controller(ExternalInventory extInv, ExternalAccounting extAcc, Printer printer){
        this.extInv = extInv; 
        this.extAcc = extAcc;
        this.printer = printer; 
    }
    /**
     * Creates a new Sale object and returns a SaleDTO object representing the current sale state.
     * @return sale.getSaleInfo() Returns the SaleDTO initialized at the beggining. 
     */
    public SaleDTO startSale() {
        
        this.sale = new Sale();
        return sale.getSaleInfo();
    }
    /**
     * Retrieves an item from ExternalInventory based on the given itemIdentifier and calculates the cost for the item.
     * @param itemIdentifier Requested item's ID number, used to compare and find items.
     * @param quantity Quantity of requested item for calculation. 
     * @return sale.getSaleInfo() returns the SaleDTO updated.
     */
    public SaleDTO registerItem(int itemIdentifier, double quantity){
        
        Item item = extInv.retrieveItem(itemIdentifier); 
        if (item == null){
            System.out.println("Invalid Item Identifier: " + Integer.toString(itemIdentifier));
        }
        else{
            sale.calculateCost(item, quantity, sale); 
        }
    return sale.getSaleInfo();
    }

    /**Creates a Payment object and updates ExternalAccounting with the paid amount.
    Updates ExternalInventory with the items that were sold. It then creates a Receipt object and sends it to the Printer to be printed.
    *@param paidAmount Holds the amount paid by the customer to then get change. 
    */
    public void pay(double paidAmount){
        
        Payment payment = new Payment(paidAmount, sale.getSaleInfo().getRunningTotal());
        extAcc.updateAccounting(paidAmount);
        extInv.updateInventory(sale);
        Receipt receipt = new Receipt(sale, payment);
        printer.printReceipt(receipt);
    }
}
