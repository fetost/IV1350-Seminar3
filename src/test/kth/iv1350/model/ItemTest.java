package test.kth.iv1350.model;

import se.kth.iv1350.integration.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * This class tests the functionality for the Item class
 */
public class ItemTest {
    
    private Item item;
    private int itemIdentifier;
    private ItemDescription itemDescription;
    private double storeQuantity;
    private double quantity;
    private String name;
    private double price;
    private double VAT;

    // Test setup method
    public void setUp() {
        // Set up the item's properties
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        quantity = 10.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity);
    }

    /**
     * Test method for the getItemDescription() method simulating the method to retrieve a certain item's description
     * using hardcoded temporary variable to simulate the information needed.
     */ 
    @Test
    public void getItemDescription() {
        // Set up the item's properties
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity);
        // Test if the item's description is equal to the expected value
        assertEquals(itemDescription, item.getItemDescription());
    }

    /** 
     *Test method for the getItemIdentifier() method simulating the method to retrieve a certain item's ID number
     * using hardcoded temporary variable to simulate the information needed.
     */ 
    @Test
    public void getItemIdentifier() {
        // Set up the item's properties
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity);
        // Test if the item's identifier is equal to the expected value
        assertEquals(itemIdentifier, item.getItemIdentifier());
    }

     /** 
     *Test method for the getQuantity() method simulating the method to retrieve the sale's total item quantity 
     * using hardcoded temporary variable to simulate the information needed.
     */ 
    @Test
    public void getQuantity() {
        // Set up the item's properties
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        quantity = 10.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity); 
        // Test if the item's quantity is equal to the expected value
        assertEquals(0.0, item.getQuantity(), 0.001); 
    }

    /** 
     *Test method for the getQuantity() method simulating the method to retrieve the store inventory's total item quantity 
     * using hardcoded temporary variable to simulate the information needed.
     */ 
    @Test
    public void getStoreQuantity() {
        // Set up the item's properties
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        quantity = 10.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity); 
        // Test if the item's store quantity is equal to the expected value
        assertEquals(500.0, item.getStoreQuantity(), 0.001);
    }

    /**
     * Test method for the setQuantity() method, checks if the sale's total quantity gets updated throughout the sale.
     */ 
    @Test
    public void setQuantity() {
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        quantity = 10.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity); 
        item.setQuantity(25.0);
        assertEquals(25.0, item.getQuantity(), 0.001);
    }

    /**
     * Test method for the setStoreQuantity() method, checks if the store inventory's total quantity gets updated throughout the sale.
     */ 
    @Test
    public void setStoreQuantity() {
        name = "banan";
        price = 10.0;
        VAT = 0.06;
        itemIdentifier = 2;
        storeQuantity = 500.0;
        quantity = 10.0;
        itemDescription = new ItemDescription(name, price, VAT);
        item = new Item(itemIdentifier, itemDescription, storeQuantity);
        item.setStoreQuantity(20);
        assertEquals(20, item.getStoreQuantity(), 0);
    }
}