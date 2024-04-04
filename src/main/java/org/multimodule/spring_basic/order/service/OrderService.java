package org.multimodule.spring_basic.order.service;

import org.multimodule.spring_basic.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
