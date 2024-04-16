package org.multimodule.spring_basic.command.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByOrderId(Long orderId);
//    Optional<Payment> findByPaymentKeyAndEmail(String paymentKey, String email);
}
