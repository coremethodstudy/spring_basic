package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.product.Product;

public interface ProductRepository {
    Product findByName(String productName);
}
