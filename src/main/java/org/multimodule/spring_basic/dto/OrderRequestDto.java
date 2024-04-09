package org.multimodule.spring_basic.dto;


import java.util.List;

public class OrderRequestDto {
    private String memberId;
//    private String itemId;
    private List<String> itemIdList;


    public OrderRequestDto(String memberId, List<String> itemIdList) {
        this.memberId = memberId;
        this.itemIdList = itemIdList;
    }

    public List<String> getItemIdList() {
        return itemIdList;
    }

    public String getMemberId() {
        return memberId;
    }
}
