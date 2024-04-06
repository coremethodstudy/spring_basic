package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.product.Product;

import java.util.HashMap;
import java.util.Map;

public class CarProductRepository implements ProductRepository {

    public static final Map<Long, Product> productStore = new HashMap<>();
    @Override
    public void save(Product product) {
        productStore.put(product.getId(), product);
    }
}
