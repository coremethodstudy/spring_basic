package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.order.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);
    List<Order> findAllById(Long memberId);
}
