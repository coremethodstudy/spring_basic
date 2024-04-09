package org.multimodule.spring_basic.config;

import org.multimodule.spring_basic.command.application.*;
import org.multimodule.spring_basic.query.*;
import org.multimodule.spring_basic.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberDao()
                ,orderRepository()
                ,itemRepositoryList()
                ,discountPolicy()
        );
    }

    @Bean
    public List<ItemRepository> itemRepositoryList() {
        List<ItemRepository> itemRepositoryList = new ArrayList<>();
        itemRepositoryList.add(new CarItemRepository());
        itemRepositoryList.add(new HomeApplianceRepository());
        itemRepositoryList.add(new ElectronicProductRepository());
        return itemRepositoryList;
    }

    @Bean
    public MemberRepository memberRepository() { return new MemoryMemberRepository(); }

    @Bean
    public MemberDao memberDao() { return new MemoryMemberDao(); }

    @Bean
    public OrderRepository orderRepository() {
        return new DiscountOrderRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

    @Bean
    public ItemRepository itemRepository() { return new CarItemRepository(); }

}
