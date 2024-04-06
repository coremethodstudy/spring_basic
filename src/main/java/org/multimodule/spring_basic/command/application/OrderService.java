package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.order.Order;
import org.multimodule.spring_basic.dto.OrderRequestDto;

public interface OrderService {
    void create(OrderRequestDto orderRequestDto);
    Order findOrder(Long memberId);
}
