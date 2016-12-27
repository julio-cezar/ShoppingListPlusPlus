package com.maracujasoftware.shoppinglistplusplus.model;

/**
 * Defines the data structure for ShoppingListItem objects.
 */
public class ShoppingListItem {
    private String itemName;
    private String owner;

    /**
     * Required public constructor
     */
    public ShoppingListItem() {
    }

    /**
     * Use this constructor to create new ShoppingListItem.
     * Takes shopping list item name and list item owner email as params
     *
     * @param itemName
     *
     */
    public ShoppingListItem(String itemName, String owner) {
        this.itemName = itemName;
        this.owner = owner;

    }

    public String getItemName() { return itemName; }

    public String getOwner() {
        return owner;
    }


}
