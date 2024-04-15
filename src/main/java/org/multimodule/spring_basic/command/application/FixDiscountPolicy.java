package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class FixDiscountPolicy implements DiscountPolicy {

    private final int vipDiscountPrice = 1000;
    @Override
    public int discountByGrade(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return vipDiscountPrice;
        } else {
            return 0;
        }
    }
}
