package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {

    private final int vipDiscountPrice = 1000;
    @Override
    public int discountByGrade(Member member, int price) {
        if(member.getGrade().equals(Grade.VIP)) {
            return vipDiscountPrice;
        } else {
            return 0;
        }
    }
}
