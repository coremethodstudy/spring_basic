package org.multimodule.spring_basic.order.discount;

public class FixDiscount implements DiscountPolicy{
    @Override
    public int getDiscountPrice(int price) {
        return price-500;
    }
}
