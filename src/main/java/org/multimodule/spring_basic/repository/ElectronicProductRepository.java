package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.item.Item;
import org.multimodule.spring_basic.repository.ItemRepository;

import static org.multimodule.spring_basic.repository.CarItemRepository.productStore;

public class ElectronicProductRepository implements ItemRepository {
    @Override
    public void save(Item item) {
        productStore.put(item.getId(), item);
    }

    @Override
    public Item findById(Long id) {
        return productStore.get(id);
    }
}
