//package org.multimodule.spring_basic;
//
//import org.multimodule.spring_basic.command.application.MemberService;
//import org.multimodule.spring_basic.command.application.OrderService;
//import org.multimodule.spring_basic.command.domain.item.Item;
//import org.multimodule.spring_basic.command.domain.member.Grade;
//import org.multimodule.spring_basic.command.domain.member.Member;
//import org.multimodule.spring_basic.command.domain.order.Order;
//import org.multimodule.spring_basic.config.AppConfig;
//import org.multimodule.spring_basic.dto.OrderRequestDto;
//import org.multimodule.spring_basic.repository.ItemRepository;
//import org.multimodule.spring_basic.repository.OrderRepository;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
//public class OrderApp {
//
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
//        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//
//        long memberId = 1L;
//        Member member = new Member(memberId, "mamberA", Grade.VIP);
//        memberService.join(member);
//
//        Item item = new Item(2L, "itemA", 10000);
//        ItemRepository itemRepository = applicationContext.getBean("itemRepository", ItemRepository.class);
//        itemRepository.save(item);
//
////        OrderRequestDto orderRequestDto = new OrderRequestDto("1", "2");
////        orderService.create(orderRequestDto);
////
////        OrderRepository orderRepository = applicationContext.getBean("orderRepository", OrderRepository.class);
////        Order order = orderRepository.findById(Long.parseLong(orderRequestDto.getMemberId()));
////        System.out.println("order = " + order);
//    }
//}
