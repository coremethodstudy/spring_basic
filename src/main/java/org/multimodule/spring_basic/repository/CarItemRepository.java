package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.item.Item;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarItemRepository implements ItemRepository {

    public static final Map<Long, Item> productStore = new ConcurrentHashMap<>();
    @Override
    public void save(Item item) {
        productStore.put(item.getId(), item);
    }
}
