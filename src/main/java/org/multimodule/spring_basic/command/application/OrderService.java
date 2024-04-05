package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.order.Order;

public interface OrderService {
    void order(Long memberId, String productName, String productPrice);
    Order findOrder(Long memberId);
}
