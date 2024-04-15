package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public interface DiscountPolicy {
    int discountByGrade(Member member, int price);
}
