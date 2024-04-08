package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.query.MemberData;

public interface DiscountPolicy {
    int discountByGrade(MemberData memberData, int price);
}
