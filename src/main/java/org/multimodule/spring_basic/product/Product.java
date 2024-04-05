package org.multimodule.spring_basic.product;

public class Product {

    private Long id;
    private String productName;

    public Product(Long id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }
}
