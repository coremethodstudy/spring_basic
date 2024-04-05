package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;

public class FixedDiscountPolicy implements DiscountService {

    private final int vipDiscountPrice = 1000;
    @Override
    public int discountByGrade(Member member, int price) {
        if(member.getGrade().equals(Grade.VIP)) {
            price -= vipDiscountPrice;
        }
        return price;
    }
}
