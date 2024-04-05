package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.member.Member;

public interface DiscountPolicy {
    int discountByGrade(Member member, int price);
}
