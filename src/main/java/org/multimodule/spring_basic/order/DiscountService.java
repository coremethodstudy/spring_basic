package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;

public interface DiscountService {
    int discountByGrade(Member member, int price);
}
