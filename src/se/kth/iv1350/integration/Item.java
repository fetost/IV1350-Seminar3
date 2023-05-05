package se.kth.iv1350.integration;

/**
  * This class represents an item with its corresponding item description, item identifier, quantity and store quantity.
  */
 public class Item {
    private ItemDescription itemDescription; 
    private int itemIdentifier; 
    private double quantity; 
    private double storeQuantity; 

    /**
    *The constructor for the item.
    */
    public Item(int itemIdentifier, ItemDescription itemDescription, double storeQuantity){
        this.itemIdentifier = itemIdentifier;
        this.storeQuantity = storeQuantity;
        this.itemDescription = itemDescription;
        quantity = 0;  
    }
    /**
     *Getter method to get the item identifier.
     *@return itemIdentifier
     */
    public int getItemIdentifier(){
        return this.itemIdentifier;
    }

    /**
    *Getter method to get the quantity of the item.
    *@return quantity
    */
    public double getQuantity(){
        return quantity;
    }
    /**
    *Getter method to get the store quantity of the item.
    *@return storeQuantity
    */
    public double getStoreQuantity(){
        return this.storeQuantity;
    }

    /**
     * Getter method to get the item description.
     * @return itemDesciption
     */
    public ItemDescription getItemDescription(){
        return this.itemDescription;
    }

    /**
     * Setter method to set the quantity of the item.
     * @param newQuantity Decides the quantity to be changed to for the sale.
     */
    public void setQuantity(double newQuantity) {
        quantity = newQuantity;
    }

    /**  
     * Setter method to set the store quantity of the item.
     * @param newStoreQuantity Decides the quantity to be changed to for the store inventory.
     */ 
    public void setStoreQuantity(double newStoreQuantity){
        this.storeQuantity = newStoreQuantity;
    }
}
