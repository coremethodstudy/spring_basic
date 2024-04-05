package org.multimodule.spring_basic;

import org.multimodule.spring_basic.discount.FixDiscountPolicy;
import org.multimodule.spring_basic.member.MemberService;
import org.multimodule.spring_basic.member.MemberServiceImpl;
import org.multimodule.spring_basic.member.MemoryMemberRepository;
import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.OrderServiceImpl;

public class AppConfig {

    //이렇게 하면 MemberService를 사용할때 MemoryMemberRepository를 사용할 수 있게 함
    //즉 MemberServiceImpl에서는 MemoryMemberRepository를 알 수 없다
    //생성자를 통해서 주입하는 것임 이것이!!!!!!!!!!!!생성자 주입!!!!!!!!!!!!!!!!!!!!
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
