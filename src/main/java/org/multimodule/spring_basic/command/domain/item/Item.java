package org.multimodule.spring_basic.command.domain.item;

public class Item {

    private Long id;
    private String itemName;
    private int itemPrice;

    public Item(Long id, String itemName, int itemPrice) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
