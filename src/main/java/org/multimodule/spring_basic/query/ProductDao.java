package org.multimodule.spring_basic.query;

import java.util.List;

public interface ProductDao {
    List<ProductData> findAll();
}
