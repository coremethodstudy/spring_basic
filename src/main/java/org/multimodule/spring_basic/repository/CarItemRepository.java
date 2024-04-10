package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CarItemRepository implements ItemRepository {

    public static final Map<Long, Item> productStore = new ConcurrentHashMap<>();
    @Override
    public void save(Item item) {
        productStore.put(item.getId(), item);
    }

    @Override
    public Item findById(Long id) {
        return productStore.get(id);
    }
}
