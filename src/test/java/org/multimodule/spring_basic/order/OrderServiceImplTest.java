package org.multimodule.spring_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.application.MemberService;
import org.multimodule.spring_basic.command.application.MemberServiceImpl;
import org.multimodule.spring_basic.command.domain.order.Order;
import org.multimodule.spring_basic.command.application.OrderService;
import org.multimodule.spring_basic.command.application.OrderServiceImpl;

class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void 주문_생성() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);

        //when
        orderService.order(foundMember.getId(), "캉골가방", "200000");
        Order order = orderService.findOrder(1L);

        //then
        Assertions.assertThat(order.getProductPrice()).isEqualTo(200000);
    }
}