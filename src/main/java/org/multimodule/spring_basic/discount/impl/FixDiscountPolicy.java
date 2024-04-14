package org.multimodule.spring_basic.discount.impl;

import jakarta.annotation.Resource;
import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;

//@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1_000;
    
    @Override
    public int discount(Member member, int price) {
        System.out.println(this.getClass());
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }

}
