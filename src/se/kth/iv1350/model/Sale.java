package se.kth.iv1350.model;

import java.time.*;
import java.util.*;
import se.kth.iv1350.integration.*;

public class Sale {
   
    private LocalDateTime dateAndTime;  
    private List<Item> items;
    private SaleDTO saleInfo;
    private double runningTotal; 
    private double addedVAT; 
    
    
     //Creates a new instance of Sale with current date and time, an empty list of items, and a SaleDTO with zero running total, zero VAT and null items.

    public Sale(){
        this.dateAndTime = LocalDateTime.now();
        this.items = new ArrayList<>(); 
        this.saleInfo = new SaleDTO(dateAndTime, 0.0, 0.0, null);   
    }

    /** 
    Returns information about the sale.
    @return The sale information.
    */
    public SaleDTO getSaleInfo(){
        return this.saleInfo;
    }

    /**
    Adds an item to the list of items for the sale, and updates the sale information.
    @param item The item to add.
    */
    public void addItem(Item item){
        items.add(item);
        this.saleInfo = new SaleDTO(this.dateAndTime, this.runningTotal, this.addedVAT, this.items); 
    }

    /**
    Calculates the cost for an item and updates the running total and added VAT, and updates the sale information. 
    @param item The item to calculate the cost for.
    @param quantity The quantity of the item.
    @param sale The sale to calculate the cost for.
    */
    public void calculateCost(Item item, double quantity, Sale sale){
        isSameItem(item, quantity);
        addVAT(item.getItemDescription().getVAT(), quantity, item.getItemDescription().getPrice());
        updateRunningTotal(item.getItemDescription().getPrice(), quantity, item.getItemDescription().getVAT());
    }

   
    private void addVAT(double VAT, double quantity, double price){  
        this.addedVAT += (VAT*price)*quantity;
        this.saleInfo = new SaleDTO(this.dateAndTime, this.runningTotal, this.addedVAT, this.items); 
    }

    
    private void updateRunningTotal(double price, double quantity, double VAT){
        this.runningTotal += (price + (price * VAT)) * quantity;
        this.saleInfo = new SaleDTO(this.dateAndTime, this.runningTotal, this.addedVAT, this.items); 
    }

   
    private void isSameItem(Item item, double quantity) {
        boolean correctItem = false;
        for (Item duplicate : items) {
            if (duplicate.getItemDescription().equals(item.getItemDescription())) {
                correctItem = true;
                item.setQuantity(duplicate.getQuantity() + quantity);
                break;
            }
        }
        if (!correctItem) {
            items.add(item);
            item.setQuantity(item.getQuantity() + quantity); 
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
