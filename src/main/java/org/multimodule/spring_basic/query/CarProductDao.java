package org.multimodule.spring_basic.query;

import org.multimodule.spring_basic.command.domain.product.Product;

import java.util.List;
import java.util.stream.Collectors;

import static org.multimodule.spring_basic.repository.CarProductRepository.productStore;

public class CarProductDao implements ProductDao {

    @Override
    public List<ProductData> findAll() {
        List<Product> productList = productStore.values()
                .stream()
                .collect(Collectors.toList());

        return productList.stream()
                .map(p -> new ProductData())
                .collect(Collectors.toList());
    }
}
