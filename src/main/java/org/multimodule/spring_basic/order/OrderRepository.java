package org.multimodule.spring_basic.order;

public interface OrderRepository {

    void save(Order order);

    Order findById(Long memberId);
}
