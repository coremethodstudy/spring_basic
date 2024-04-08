package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.discount.FixDiscountPolicy;
import org.multimodule.spring_basic.discount.RateDiscountPolicy;
import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.MemberRepository;
import org.multimodule.spring_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //이렇게 하면 이제 DIP는 지킨 것....그런데 구체클래스를 어떻게 주입을 해줄까..? 다음시간에.....
//    private DiscountPolicy discountPolicy;

    //DIP를 지켜서 구체클래스를 주입하는 방법
    //생성자를 통해서 주입한다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //싱글톤 검증 코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
