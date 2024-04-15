package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.annotation.MainDiscountPolicy;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class RateDiscountPolicy implements DiscountPolicy {

    private final double rateDiscount = 0.1;
    @Override
    public int discountByGrade(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return (int) (price * rateDiscount);
        } else {
            return 0;
        }
    }
}
