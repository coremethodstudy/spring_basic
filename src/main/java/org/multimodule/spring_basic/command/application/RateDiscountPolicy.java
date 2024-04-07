package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.query.MemberData;

public class RateDiscountPolicy implements DiscountPolicy {

    private final double rateDiscount = 0.1;
    @Override
    public int discountByGrade(MemberData member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return (int) (price * rateDiscount);
        } else {
            return 0;
        }
    }
}
