package org.multimodule.spring_basic.order;

public class Order {

    private Long id;
    private Long memberId;
    private String productName;
    private int productPrice;

    public Order(Long memberId, String productName, int productPrice) {
        this.memberId = memberId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
