package org.multimodule.spring_basic;

import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.discount.impl.FixDiscountPolicy;
import org.multimodule.spring_basic.discount.impl.RateDiscountPolicy;
import org.multimodule.spring_basic.member.repository.MemberRepository;
import org.multimodule.spring_basic.member.repository.impl.MemoryMemberRepositoryImpl;
import org.multimodule.spring_basic.member.service.MemberService;
import org.multimodule.spring_basic.member.service.impl.MemberServiceImpl;
import org.multimodule.spring_basic.order.service.OrderService;
import org.multimodule.spring_basic.order.service.impl.OrderServiceImpl;

/**
 * packageName    : org.multimodule.spring_basic
 * fileName       : AppConfig
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memoryMemberRepository(),
                fixDiscountPolicy()
        );
    }

    private MemberRepository memoryMemberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    private DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }

    private DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
