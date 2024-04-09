package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DiscountOrderRepository implements OrderRepository {

    private static Map<Long, List<Order>> orderStore = new ConcurrentHashMap<>();
    @Override
    public void save(Order order) {
        if(orderStore.containsKey(order.getMemberId())) {
            List<Order> orders = orderStore.get(order.getMemberId());
            orders.add(order);
        } else {
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            orderStore.put(order.getMemberId(), orderList);
        }
    }

    @Override
    public List<Order> findAllById(Long memberId) {
        List<Order> orders = orderStore.get(memberId);
        return orders;
    }
}
