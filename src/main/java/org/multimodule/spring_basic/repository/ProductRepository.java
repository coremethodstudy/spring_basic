package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.product.Product;

public interface ProductRepository {
    Product findByName(String productName);
}
