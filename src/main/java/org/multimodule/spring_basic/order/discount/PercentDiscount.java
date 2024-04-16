package org.multimodule.spring_basic.order.discount;

public class PercentDiscount implements DiscountPolicy{
    @Override
    public int getDiscountPrice(int price) {
        return (int) (price-(price*0.01));
    }
}
