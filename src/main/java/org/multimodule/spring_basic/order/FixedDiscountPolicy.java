package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.member.Grade;

public class FixedDiscountPolicy implements DiscountService {

    private final int vipDiscountPrice = 1000;
    @Override
    public int discountByGrade(Grade grade, int price) {
        if(grade.equals(Grade.VIP)) {
            price -= vipDiscountPrice;
        }
        return price;
    }
}
