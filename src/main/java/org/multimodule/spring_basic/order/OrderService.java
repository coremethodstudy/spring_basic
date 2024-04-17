package org.multimodule.spring_basic.order;


import lombok.Getter;
import org.multimodule.spring_basic.order.discount.DiscountPolicy;

public class OrderService {

    private final DiscountPolicy discountPolicy;
    @Getter
    private final MemberRepository memberRepository;
    private int price;

    public OrderService(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
