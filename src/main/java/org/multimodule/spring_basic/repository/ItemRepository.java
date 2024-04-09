package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.item.Item;

public interface ItemRepository {
    void save(Item item);

    Item findById(Long id);
}
