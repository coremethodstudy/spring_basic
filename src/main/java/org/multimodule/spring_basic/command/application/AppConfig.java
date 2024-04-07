package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.query.CarItemDao;
import org.multimodule.spring_basic.query.MemoryMemberDao;
import org.multimodule.spring_basic.repository.CarItemRepository;
import org.multimodule.spring_basic.repository.DiscountOrderRepository;
import org.multimodule.spring_basic.repository.ItemRepository;
import org.multimodule.spring_basic.repository.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberDao()
                ,new DiscountOrderRepository()
                ,new CarItemDao()
                ,new RateDiscountPolicy()
        );
    }

    public ItemRepository itemRepository() {
        return new CarItemRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
