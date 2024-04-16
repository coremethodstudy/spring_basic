package org.multimodule.spring_basic.order.discount;

public interface DiscountPolicy {
    int getDiscountPrice(int price);
}
