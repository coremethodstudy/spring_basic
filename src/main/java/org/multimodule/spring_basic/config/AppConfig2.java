package org.multimodule.spring_basic.config;

import org.multimodule.spring_basic.order.MemberRepository;
import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.discount.DiscountPolicy;
import org.multimodule.spring_basic.order.discount.FixDiscount;
import org.multimodule.spring_basic.order.discount.MemberService;
import org.multimodule.spring_basic.order.discount.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean
    public OrderService orderService(){
        return new OrderService(
                discountPolicy()
                ,memoryMemberRepository()
        );
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(
                memoryMemberRepository()
        );
    }


    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscount();
    }

    @Bean
    public MemberRepository memoryMemberRepository(){
        System.err.println("@@@@@@ memoryMemberRepository @@@@@");
        return new MemoryMemberRepository();
    }

}
