package org.multimodule.spring_basic.command.domain.order;

public class Order {

    private Long memberId;
    private String productName;
    private int productPrice;
    private int productDiscountPrice;

    public Order(Long memberId, String productName, int productPrice, int productDiscountPrice) {
        this.memberId = memberId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
    }

    public int calculatePrice() {
        return productPrice - productDiscountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductDiscountPrice() {
        return productDiscountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDiscountPrice=" + productDiscountPrice +
                '}';
    }
}
