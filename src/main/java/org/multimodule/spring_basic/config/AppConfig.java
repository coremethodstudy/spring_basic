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
                ,itemDaoList()
                ,discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() { return new MemoryMemberRepository(); }

    @Bean
    public MemberDao memberDao() { return new MemoryMemberDao(); }

    @Bean
    public OrderRepository orderRepository() {
        return new DiscountOrderRepository();
    }

//    @Bean
//    public ItemDao itemDao() { return new CarItemDao(); }


    @Bean
    public List<ItemDao> itemDaoList() {
        List<ItemDao> itemDaoList = new ArrayList<>();
        itemDaoList.add(new CarItemDao());
        itemDaoList.add(new HomeApplianceDao());
        return itemDaoList;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

    @Bean
    public ItemRepository itemRepository() { return new CarItemRepository(); }

}
