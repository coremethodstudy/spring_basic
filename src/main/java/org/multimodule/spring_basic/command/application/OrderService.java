package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.order.Order;
import org.multimodule.spring_basic.dto.OrderRequestDto;

import java.util.List;

public interface OrderService {
    void create(OrderRequestDto orderRequestDto);
    List<Order> findAllById(Long memberId);
}
