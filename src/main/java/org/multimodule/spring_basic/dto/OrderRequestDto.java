package org.multimodule.spring_basic.dto;


public class OrderRequestDto {
    private String memberId;
    private String itemId;

    public OrderRequestDto(String memberId, String itemId) {
        this.memberId = memberId;
        this.itemId = itemId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getItemId() {
        return itemId;
    }
}
