package org.multimodule.spring_basic.order.service.impl;

import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.repository.MemberRepository;
import org.multimodule.spring_basic.order.Order;
import org.multimodule.spring_basic.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findMemberById(memberId);
        int discount = discountPolicy.discount(findMember, itemPrice);
        Order order = new Order(memberId, itemName, itemPrice, discount);

        System.out.println(this.getClass());
        System.out.println(order);

        return order;
    }

}
