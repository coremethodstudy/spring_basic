package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.query.MemberDao;
import org.multimodule.spring_basic.query.MemberData;
import org.multimodule.spring_basic.query.MemoryMemberDao;
import org.multimodule.spring_basic.repository.*;
import org.multimodule.spring_basic.command.domain.order.*;
import org.multimodule.spring_basic.command.domain.product.Product;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository = new DiscountOrderRepository();
    private final MemberDao memberDao = new MemoryMemberDao();
    private final ProductRepository productRepository = new CarProductRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
    @Override
    public void order(Long memberId, String productName, String productPrice) {
        //회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
        MemberData member = memberDao.findById(memberId);

        Product product = productRepository.findByName(productName);

        int price = Integer.parseInt(productPrice);

        //할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
        int discountPrice = discountPolicy.discountByGrade(member, price);

        //주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.
        Order order = new Order(memberId, productName, price, discountPrice);

        orderRepository.save(order);
    }

    @Override
    public Order findOrder(Long memberId) {
        return orderRepository.findById(memberId);
    }
}
