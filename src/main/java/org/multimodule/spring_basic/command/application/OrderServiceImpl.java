package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.dto.OrderRequestDto;
import org.multimodule.spring_basic.query.*;
import org.multimodule.spring_basic.repository.*;
import org.multimodule.spring_basic.command.domain.order.*;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository = new DiscountOrderRepository();
    private final MemberDao memberDao = new MemoryMemberDao();
    private final ItemDao itemDao = new CarItemDao();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy2 = new RateDiscountPolicy();
    @Override
    public void create(OrderRequestDto orderRequestDto){
        //회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
        MemberData member = memberDao.findById(Long.parseLong((orderRequestDto.getMemberId())));

        ItemData itemData = itemDao.findById(Long.parseLong(orderRequestDto.getItemId()));
        
        //할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
        int discountPrice = discountPolicy.discountByGrade(member, itemData.getItemPrice());

        //주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.
        Order order = new Order(Long.parseLong(orderRequestDto.getMemberId()), itemData.getItemName(), itemData.getItemPrice(), discountPrice);

        orderRepository.save(order);
    }

    @Override
    public Order findOrder(Long memberId) {
        return orderRepository.findById(memberId);
    }
}
