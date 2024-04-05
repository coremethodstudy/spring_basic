package org.multimodule.spring_basic.order;

import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.MemberRepository;
import org.multimodule.spring_basic.member.MemoryMemberRepository;
import org.multimodule.spring_basic.product.Product;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository = new DiscountOrderRepository();
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final ProductRepository productRepository = new CarProductRepository();
    private final DiscountService discountService = new FixedDiscountPolicy();
    @Override
    public void order(Long memberId, String productName, String productPrice) {
        //회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회한다.
        Member member = memberRepository.findById(memberId);

        Product product = productRepository.findByName(productName);

        int price = Integer.parseInt(productPrice);

        //할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.
        int discountedPrice = discountService.discountByGrade(member.getGrade(), price);


        //주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.
        Order order = new Order(memberId, productName, discountedPrice);

        orderRepository.save(order);
    }
}
