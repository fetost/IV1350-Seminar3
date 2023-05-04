package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.lang.StringBuilder;
import java.lang.Math;

public class Receipt {
    private Sale sale;
    private Payment payment;
   
    /**
    *Initialize the Receipt with a Sale and Payment objects
    *@param sale Holds the sale information to be printed.
    *@param payment Holds the information concerning payment method and amount to be returned.
    */
    public Receipt(Sale sale, Payment payment){
        
        this.sale = sale;
        this.payment = payment;
    }

    /**
     *  Utility method to append a line to the StringBuilder
     * @param builder
     * @param line 
     */
    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    /** 
     * Utility method to end a section in the StringBuilder
     * @param builder
     */
    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }

    /**
     * Method that creates a receipt as a String
     * @return builder.toString() 
     */
    public String createReceipt() {
        StringBuilder builder = new StringBuilder();

        // Append store name
        appendLine(builder, "Royan and Pjotr livs");
        endSection(builder);

        LocalDateTime timeOfSale = LocalDateTime.now();
        // Append current time
        builder.append("Current time: ");
        appendLine(builder, timeOfSale.toString());
        endSection(builder);
    
        // Append items and their prices
        builder.append("Purchased items: ");
        builder.append("\n");
    
        for (int i = 0; i < sale.getItems().size(); i++) {
            builder.append(sale.getItems().get(i).getItemDescription().getName() + " " + sale.getItems().get(i).getQuantity() + "st ");
            appendLine(builder, Double.toString(sale.getItems().get(i).getItemDescription().getPrice()) + "kr/st");
        }

        builder.append("\n");

        // Append running total
        builder.append("Running Total: " + Math.round(sale.getSaleInfo().getRunningTotal()));
        builder.append("\n");

        builder.append("\n");

        // Append added VAT
        builder.append("Total VAT: " + sale.getSaleInfo().getAddedVAT());
        builder.append("\n");
    
        builder.append("\n");

        // Append amount paid
        builder.append("Amount Paid: " + Math.round(payment.getPaidAmount())); 
        builder.append("\n");

        builder.append("\n");

        // Append change returned
        builder.append("Change returned: " + Math.round(payment.getChange()));  
        builder.append("\n");

        endSection(builder);

        // Return the receipt as a String
        return builder.toString();
    }
}