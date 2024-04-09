package org.multimodule.spring_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.command.application.*;
import org.multimodule.spring_basic.command.domain.item.Car;
import org.multimodule.spring_basic.command.domain.item.Item;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.domain.order.Order;
import org.multimodule.spring_basic.config.AppConfig;
import org.multimodule.spring_basic.dto.OrderRequestDto;
import org.multimodule.spring_basic.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

class OrderServiceImplTest {

    OrderService orderService;
    MemberService memberService;
    ItemRepository itemRepository;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
        itemRepository = appConfig.itemRepository();
    }

    @Test
    public void 주문_생성() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);
        Item item = new Item(2L, "pencil", 2000);
        Car bmwCar = new Car(3L, "BMW", 100000000);
        itemRepository.save(item);
        itemRepository.save(bmwCar);
        List<String> orderRequestDtoList = new ArrayList<>();
        orderRequestDtoList.add("2");
        orderRequestDtoList.add("3");
        OrderRequestDto orderRequestDto = new OrderRequestDto("1", orderRequestDtoList);

        //when
        orderService.create(orderRequestDto);
        List<Order> orderList = orderService.findAllById(1L);

        //then
        Assertions.assertThat(orderList.size()).isEqualTo(2);
    }
}