package org.multimodule.spring_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.MemberService;
import org.multimodule.spring_basic.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

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