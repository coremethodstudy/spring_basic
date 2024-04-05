package org.multimodule.spring_basic.order;

import java.util.HashMap;
import java.util.Map;

public class DiscountOrderRepository implements OrderRepository {

    private static Map<Long, Order> orderStore = new HashMap<>();
    @Override
    public void save(Order order) {
        orderStore.put(order.getMemberId(), order);
    }

    @Override
    public Order findById(Long memberId) {
        return orderStore.get(memberId);
    }
}
