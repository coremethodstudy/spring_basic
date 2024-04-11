package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.item.Item;
import org.multimodule.spring_basic.dto.OrderRequestDto;
import org.multimodule.spring_basic.query.*;
import org.multimodule.spring_basic.repository.*;
import org.multimodule.spring_basic.command.domain.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberDao memberDao;
    private final OrderRepository orderRepository;
    private final List<ItemRepository> itemRepositoryList;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberDao memberDao
                            , OrderRepository orderRepository
                            , List<ItemRepository> itemRepositoryList
                            , @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberDao = memberDao;
        this.orderRepository = orderRepository;
        this.itemRepositoryList = itemRepositoryList;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public void create(OrderRequestDto orderRequestDto){
        //회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
        MemberData memberData = memberDao.findById(Long.parseLong((orderRequestDto.getMemberId())));


        List<String> itemIdList = orderRequestDto.getItemIdList();
        List<Long> itemIdLongList = itemIdList.stream()
                .map(e -> Long.parseLong(e))
                .collect(Collectors.toList());


        Item item = null;
        List<Item> itemList = new ArrayList<>();

        for(ItemRepository itemRepository : itemRepositoryList) {
            boolean flag = false;
            for (Long id : itemIdLongList) {
                item = itemRepository.findById(id);
                if(item != null && !itemList.contains(item)) {
                    itemList.add(item);
                    flag = true;
                    break;
                }
            }

            if(flag) {
                //할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
                int discountPrice = discountPolicy.discountByGrade(memberData, item.getItemPrice());

                //주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.
                Order order = new Order(Long.parseLong(orderRequestDto.getMemberId()), item.getItemName(), item.getItemPrice(), discountPrice);

                orderRepository.save(order);
            }
        }
    }

    @Override
    public List<Order> findAllById(Long memberId) {
        return orderRepository.findAllById(memberId);
    }

}