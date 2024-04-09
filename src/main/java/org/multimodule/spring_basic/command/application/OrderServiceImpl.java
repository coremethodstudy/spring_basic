package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.dto.OrderRequestDto;
import org.multimodule.spring_basic.exception.ItemDomainException;
import org.multimodule.spring_basic.query.*;
import org.multimodule.spring_basic.repository.*;
import org.multimodule.spring_basic.command.domain.order.*;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private final MemberDao memberDao;
    private final OrderRepository orderRepository;
//    private final ItemDao itemDao;
    private final List<ItemDao> itemDaoList;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberDao memberDao
                            , OrderRepository orderRepository
//                            ,ItemDao itemDao
                            , List<ItemDao> itemDaoList
                            , DiscountPolicy discountPolicy) {
        this.memberDao = memberDao;
        this.orderRepository = orderRepository;
//        this.itemDao = itemDao;
        this.itemDaoList = itemDaoList;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public void create(OrderRequestDto orderRequestDto){
        //회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
        MemberData memberData = memberDao.findById(Long.parseLong((orderRequestDto.getMemberId())));

        ItemData itemData = null;
        for(ItemDao itemDao : itemDaoList) {
            itemData = itemDao.findById(Long.parseLong(orderRequestDto.getItemId()));
            if(itemData != null) {
                break;
            }
        }
        if(itemData == null) {
            throw new ItemDomainException("ItemData not found");
        }
        
        //할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
        int discountPrice = discountPolicy.discountByGrade(memberData, itemData.getItemPrice());

        //주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.
        Order order = new Order(Long.parseLong(orderRequestDto.getMemberId()), itemData.getItemName(), itemData.getItemPrice(), discountPrice);

        orderRepository.save(order);
    }

    @Override
    public List<Order> findAllById(Long memberId) {
        return orderRepository.findAllById(memberId);
    }
}
