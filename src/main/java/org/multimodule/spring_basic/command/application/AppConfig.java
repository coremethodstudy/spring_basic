package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.query.CarItemDao;
import org.multimodule.spring_basic.query.MemoryMemberDao;
import org.multimodule.spring_basic.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberDao()
                ,new DiscountOrderRepository()
                ,new CarItemDao()
                ,new RateDiscountPolicy()
        );
    }

    @Bean
    public ItemRepository itemRepository() {
        return new CarItemRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new DiscountOrderRepository();
    }
}
