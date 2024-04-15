package org.multimodule.spring_basic.command.domain.payment.dto;

import lombok.Getter;

@Getter
public enum PayType {

    CARD("카드"),
    CASH("현금"),
    POINT("포인트");

    private String description;

    PayType(String description) {
        this.description = description;
    }
}
