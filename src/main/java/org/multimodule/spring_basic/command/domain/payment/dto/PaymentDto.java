package org.multimodule.spring_basic.command.domain.payment.dto;

import lombok.Getter;
import lombok.Setter;
import org.multimodule.spring_basic.command.domain.payment.Payment;

import java.util.UUID;

@Getter
@Setter
public class PaymentDto {

    private String memberId;
    private PayType payType;
    private Long amount;
    private String orderName;

    private String yourSuccessUrl;
    private String yourFailUrl;

    public PaymentDto(String memberId, PayType payType, Long amount, String orderName, String yourSuccessUrl, String yourFailUrl) {
        this.memberId = memberId;
        this.payType = payType;
        this.amount = amount;
        this.orderName = orderName;
        this.yourSuccessUrl = yourSuccessUrl;
        this.yourFailUrl = yourFailUrl;
    }


    public Payment toEntity() {
        return new Payment(payType
                            ,amount
                            ,orderName
                            ,UUID.randomUUID().toString()
                            ,false);
    }
}
