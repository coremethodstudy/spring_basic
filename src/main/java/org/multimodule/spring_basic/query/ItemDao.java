package org.multimodule.spring_basic.query;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ItemDao {
    List<ItemData> findAll();

    ItemData findById(Long itemId);
}
