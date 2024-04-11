package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.query.MemberData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private final int vipDiscountPrice = 1000;
    @Override
    public int discountByGrade(MemberData memberData, int price) {
        if(memberData.getGrade() == Grade.VIP) {
            return vipDiscountPrice;
        } else {
            return 0;
        }
    }
}
