package org.multimodule.spring_basic.order;

public interface OrderService {
    void order(Long memberId, String productName, String productPrice);
}
