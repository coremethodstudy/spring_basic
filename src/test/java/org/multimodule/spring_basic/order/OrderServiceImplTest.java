package org.multimodule.spring_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.command.application.*;
import org.multimodule.spring_basic.command.domain.item.Item;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.domain.order.Order;
import org.multimodule.spring_basic.dto.OrderRequestDto;
import org.multimodule.spring_basic.repository.CarItemRepository;
import org.multimodule.spring_basic.repository.ItemRepository;

class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();
    ItemRepository itemRepository = new CarItemRepository();

    @Test
    void 주문_생성() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);
        Item item = new Item(2L, "Sonata", 32000000);
        itemRepository.save(item);

        OrderRequestDto orderRequestDto = new OrderRequestDto("1", "2");


        //when
        orderService.create(orderRequestDto);
        Order order = orderService.findOrder(1L);

        //then
        Assertions.assertThat(order.getItemPrice()).isEqualTo(32000000);
    }
}