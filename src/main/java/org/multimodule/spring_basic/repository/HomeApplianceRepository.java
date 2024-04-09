package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.item.Item;

import static org.multimodule.spring_basic.repository.CarItemRepository.productStore;

public class HomeApplianceRepository implements ItemRepository{
    @Override
    public void save(Item item) {
        productStore.put(item.getId(), item);
    }
}
