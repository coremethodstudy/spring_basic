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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memoryMemberRepository(),
                rateDiscountPolicy()
        );
    }

    @Bean
    public MemberRepository memoryMemberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    @Bean(name = "fixDiscountPolicy")
    public DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean(name = "rateDiscountPolicy")
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }

}
