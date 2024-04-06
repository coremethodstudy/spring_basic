package org.multimodule.spring_basic.query;

import java.util.List;

public interface ItemDao {
    List<ItemData> findAll();

    ItemData findById(Long itemId);
}
