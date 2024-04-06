package org.multimodule.spring_basic.query;

import org.multimodule.spring_basic.command.domain.item.Item;

import java.util.List;
import java.util.stream.Collectors;

import static org.multimodule.spring_basic.repository.CarItemRepository.productStore;

public class CarItemDao implements ItemDao {

    @Override
    public List<ItemData> findAll() {
        List<Item> itemList = productStore.values()
                .stream()
                .collect(Collectors.toList());

        return itemList.stream()
                .map(p -> new ItemData())
                .collect(Collectors.toList());
    }

    @Override
    public ItemData findById(Long itemId) {
        Item item = productStore.get(itemId);
        return new ItemData(item.getItemName(), item.getItemPrice());
    }
}
