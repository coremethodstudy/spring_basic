package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.query.MemberData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy {

    private final double rateDiscount = 0.1;
    @Override
    public int discountByGrade(MemberData memberData, int price) {
        if(memberData.getGrade() == Grade.VIP) {
            return (int) (price * rateDiscount);
        } else {
            return 0;
        }
    }
}
