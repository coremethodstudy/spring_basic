package org.multimodule.spring_basic.dto;


public class OrderRequestDto {
    private String memberId;
    private String productId;

    public OrderRequestDto(String memberId, String productId) {
        this.memberId = memberId;
        this.productId = productId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getProductId() {
        return productId;
    }
}
