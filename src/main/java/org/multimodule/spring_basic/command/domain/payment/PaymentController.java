package org.multimodule.spring_basic.command.domain.payment;

import org.multimodule.spring_basic.command.domain.payment.dto.PaymentDto;
import org.multimodule.spring_basic.command.domain.payment.dto.PaymentResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;
//    private final TossPaymentConfig tossPaymentConfig;
//    private final PaymentMapper mapper;

    public PaymentController(PaymentService paymentService
//            , TossPaymentConfig tossPaymentConfig
//            , PaymentMapper mapper
    ) {
        this.paymentService = paymentService;
//        this.tossPaymentConfig = tossPaymentConfig;
//        this.mapper = mapper;
    }

    @PostMapping("/toss")
    public ResponseEntity requestTossPayment(@RequestBody PaymentDto paymentDto) {
        PaymentResDto paymentResDto = paymentService.requestTossPayment(paymentDto);
//        paymentResDto.setSuccessUrl(paymentDto.getYourSuccessUrl() == null ? tossPaymentConfig.getSuccessUrl() : paymentDto.getYourSuccessUrl());
//        paymentResDto.setFailUrl(paymentDto.getYourFailUrl() == null ? tossPaymentConfig.getFailUrl() : paymentDto.getYourFailUrl());
        return ResponseEntity.ok().body(paymentResDto);
    }
}
