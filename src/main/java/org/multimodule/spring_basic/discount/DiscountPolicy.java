package org.multimodule.spring_basic.discount;


import org.multimodule.spring_basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
