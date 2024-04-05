package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.member.Grade;

public interface DiscountService {
    int discountByGrade(Grade grade, int price);
}
