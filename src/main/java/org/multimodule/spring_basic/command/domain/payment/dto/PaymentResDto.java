package org.multimodule.spring_basic.command.domain.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResDto {

    private String payType;
    private Long amount;
    private String orderName;
    private String orderId;
    private String customerEmail;
    private String customerName;
    private String successUrl;
    private String failUrl;

    private String failReason;
    private boolean cancelYN;
    private String cancelReason;
    private String createdAt;

    public PaymentResDto(String description, Long amount, String orderName, Long orderId, String email, String name, String createdAt, boolean cancelYN, String failReason) {
        this.payType = description;
        this.amount = amount;
        this.orderName = orderName;
        this.orderId = String.valueOf(orderId);
        this.customerEmail = email;
        this.customerName = name;
        this.createdAt = createdAt;
        this.cancelYN = cancelYN;
        this.failReason = failReason;
    }
}
