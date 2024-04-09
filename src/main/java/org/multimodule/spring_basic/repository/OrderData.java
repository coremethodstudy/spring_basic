package org.multimodule.spring_basic.repository;

public class OrderData {
    private String itemName;
    private int itemPrice;
    private int itemDiscountPrice;

    public OrderData() {
    }

    public OrderData(String itemName, int itemPrice, int itemDiscountPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDiscountPrice = itemDiscountPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getItemDiscountPrice() {
        return itemDiscountPrice;
    }
}
