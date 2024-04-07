package org.multimodule.spring_basic.discount.impl;

import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        System.out.println(this.getClass());
        return member.getGrade() == Grade.VIP ? (price * discountPercent) / 100 : 0;
    }

}
