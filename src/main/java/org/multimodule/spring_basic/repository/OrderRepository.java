package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.order.Order;

public interface OrderRepository {

    void save(Order order);

    Order findById(Long memberId);
}
