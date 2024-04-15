package org.multimodule.spring_basic.command.domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.domain.payment.dto.PayType;
import org.multimodule.spring_basic.command.domain.payment.dto.PaymentDto;
import org.multimodule.spring_basic.command.domain.payment.dto.PaymentResDto;
import org.multimodule.spring_basic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class PaymentServiceTest {

    @Autowired
    PaymentService paymentService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PaymentRepository paymentRepository;

//    @BeforeEach
//    public void beforeEach() {
//
//    }

    @Test
    @DisplayName("결제에 회원 정보 저장")
    void requestTossPaymentTest() {
        //given
        Member member = new Member(1L, "이나라", Grade.VIP);
        Member savedMember = memberRepository.save(member);

        PaymentDto paymentDto = new PaymentDto(String.valueOf(savedMember.getId())
                , PayType.CARD
        ,1000L
        ,"의자A"
        ,"localhost:8080/success"
        ,"localhost:8080/fail");


        //when
        PaymentResDto paymentResDto = paymentService.requestTossPayment(paymentDto);


        //then
        assertThat(paymentDto.getAmount()).isEqualTo(paymentResDto.getAmount());
    }
}