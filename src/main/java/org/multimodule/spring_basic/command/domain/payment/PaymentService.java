package org.multimodule.spring_basic.command.domain.payment;

import jakarta.transaction.Transactional;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.domain.payment.dto.PaymentDto;
import org.multimodule.spring_basic.command.domain.payment.dto.PaymentResDto;
import org.multimodule.spring_basic.exception.ItemDomainException;
import org.multimodule.spring_basic.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentService {

    private final MemberRepository memberRepository;
    private final PaymentRepository paymentRepository;

    public PaymentService(MemberRepository memberRepository, PaymentRepository paymentRepository) {
        this.memberRepository = memberRepository;
        this.paymentRepository = paymentRepository;
    }

    public PaymentResDto requestTossPayment(PaymentDto paymentDto) {

        Member member = memberRepository.findById(Long.parseLong(paymentDto.getMemberId()))
                .orElseThrow(() -> new IllegalArgumentException(paymentDto.getMemberId() + " id " + " member not found."));

        Payment payment = paymentDto.toEntity();

        if(payment.getAmount() < 1000) {
            throw new ItemDomainException(paymentDto.getAmount() + " is invalid paymentAmount");
        }

        payment.setMember(member);
        Payment savePayment = paymentRepository.save(payment);

        return savePayment.toPaymentResDto();
    }
}
