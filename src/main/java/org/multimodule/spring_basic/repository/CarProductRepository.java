package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.product.Product;

public class CarProductRepository implements ProductRepository {
    @Override
    public Product findByName(String productName) {
        return null;
    }
}
