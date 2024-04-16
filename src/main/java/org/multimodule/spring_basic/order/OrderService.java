package org.multimodule.spring_basic.order;


import org.multimodule.spring_basic.order.discount.DiscountPolicy;

public class OrderService {
    private final DiscountPolicy discountPolicy;
    private int price;

    public OrderService(DiscountPolicy discountPolicy) {
        System.err.println("########### OrderService 생성 ###########");
        this.discountPolicy = discountPolicy;
    }

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
