package org.multimodule.spring_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.command.application.*;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.domain.order.Order;
import org.multimodule.spring_basic.dto.OrderRequestDto;

class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void 주문_생성() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);

        OrderRequestDto orderRequestDto = new OrderRequestDto("1L", "2L");

        //when
        orderService.create(orderRequestDto);
        Order order = orderService.findOrder(1L);

        //then
        Assertions.assertThat(order.getProductPrice()).isEqualTo(200000);
    }
}