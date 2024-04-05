package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.product.Product;

public class CarProductRepository implements ProductRepository {
    @Override
    public Product findByName(String productName) {
        return null;
    }
}
