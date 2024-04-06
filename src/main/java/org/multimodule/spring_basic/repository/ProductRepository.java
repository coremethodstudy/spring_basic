package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.product.Product;

public interface ProductRepository {
    void save(Product product);
}
