package org.multimodule.spring_basic.command.domain.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int itemDiscountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int itemDiscountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDiscountPrice = itemDiscountPrice;
    }

    public int calculatePrice() {
        return itemPrice - itemDiscountPrice;
    }

    public Long getMemberId() {
        return memberId;
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

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDiscountPrice=" + itemDiscountPrice +
                '}';
    }
}
