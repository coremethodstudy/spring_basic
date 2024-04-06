package org.multimodule.spring_basic.query;


public class ItemData {
    private String itemName;
    private int itemPrice;

    public ItemData() {
    }

    public ItemData(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
