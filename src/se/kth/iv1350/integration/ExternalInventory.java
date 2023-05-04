package se.kth.iv1350.integration;

import java.util.*;
import se.kth.iv1350.model.*;


  /**
   * An external inventory system that holds information about the items in the store.
   */
 
public class ExternalInventory {
    private List<Item> storeItems = new ArrayList<>(); // a list of items in the store
	private List<ItemDescription> itemDescriptions = new ArrayList<>(); // a list of descriptions of items

    
    /**
     * Creates a new instance of ExternalInventory and adds items to the store.
     */
    public ExternalInventory(){
        addItem(); // adds items to the store when a new instance is created
    }
    
    /**
      Adds item descriptions to the itemDescriptions list and creates corresponding Item objects
      that are added to the storeItems list.
     */
    public void addItem() {
        this.itemDescriptions.add(new ItemDescription("Banan", 10.0, 0.25)); 
		this.itemDescriptions.add(new ItemDescription("Köttbullar 500g", 43.0, 0.12));
		this.itemDescriptions.add(new ItemDescription("Mjölk", 17.0, 0.06));
		this.itemDescriptions.add(new ItemDescription("Cola 2l", 29.0, 0.12));

		this.storeItems.add(new Item(1, itemDescriptions.get(0), 300.0)); // adds items to the store
		this.storeItems.add(new Item(2, itemDescriptions.get(1), 400.0));
		this.storeItems.add(new Item(3, itemDescriptions.get(2), 100.0));
		this.storeItems.add(new Item(4, itemDescriptions.get(3), 150.0));
    }

    /**
      Retrieves an Item object from the storeItems list based on its itemIdentifier.
      @param itemIdentifier the unique identifier of the item to be retrieved
      @return the Item object with the given itemIdentifier, or null if it is not found
     */
    public Item retrieveItem(int itemIdentifier){
        for (Item item: storeItems){ // iterates through the storeItems list
            if (item.getItemIdentifier() == itemIdentifier){ 
                return item; 
            }
        }
    return null; 
    }

    /**
      Updates the storeItems list by subtracting the quantity of each item in the Sale object
      from the corresponding item in the store.
      @param sale the Sale object containing the items to be updated
     */
    public void updateInventory(Sale sale) {
        List<Item> items = sale.getItems(); // gets the items in the Sale object
        for (Item item : items) { // iterates through the items
            for (Item storeItem : storeItems) { // iterates through the storeItems
                if (item.getItemIdentifier() == (storeItem.getItemIdentifier())) { 
                    double itemQuantity = item.getQuantity();
                    double storeItemQuantity = storeItem.getStoreQuantity();

                    storeItem.setStoreQuantity(storeItemQuantity - itemQuantity); // updates the store quantity
                }
            }
        }
    }
}
