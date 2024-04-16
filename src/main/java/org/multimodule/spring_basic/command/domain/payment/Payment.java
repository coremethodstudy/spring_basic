package org.multimodule.spring_basic.command.domain.payment;

import jakarta.persistence.*;
import lombok.Getter;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.domain.payment.dto.PayType;
import org.multimodule.spring_basic.command.domain.payment.dto.PaymentResDto;

import java.time.LocalDateTime;

@Entity
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PayType payType;
    private Long amount;
    private String orderName;
    private Long orderId;

    private boolean paySuccessYN;

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;

    private String paymentKey;
    private String failReason;

    private boolean cancelYN;
    private String cancelReason;
    private LocalDateTime createdAt;


    public Payment(PayType payType, Long amount, String orderName, Long orderId, boolean paySuccessYN) {
        this.payType = payType;
        this.amount = amount;
        this.orderName = orderName;
        this.orderId = orderId;
        this.paySuccessYN = paySuccessYN;
    }

    public Payment() {

    }

    public void setMember(Member member) {
        this.member = member;
        member.getPaymentList().add(this);
    }

    public PaymentResDto toPaymentResDto() {
        return new PaymentResDto(
                payType.getDescription()
                ,amount
                ,orderName
                ,orderId
                ,member.getEmail()
                ,member.getName()
                ,String.valueOf(createdAt)
                ,cancelYN
                ,failReason);
    }
}