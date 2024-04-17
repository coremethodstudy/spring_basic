package org.multimodule.spring_basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.config.AppConfig;
import org.multimodule.spring_basic.config.AppConfig2;
import org.multimodule.spring_basic.order.MemberRepository;
import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.discount.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SpringContainerTest {

    @Test
    void 싱글톤컨테이너(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService1 = ac.getBean("orderService", OrderService.class);
        OrderService orderService2 = ac.getBean("orderService", OrderService.class);

        //참조값이 같은 것을 확인
        System.out.println("orderService1 = " + orderService1);
        System.out.println("orderService2 = " + orderService2);

        //memberService1 == memberService2
        assertThat(orderService1).isSameAs(orderService2);
    }

    @Test
    void 싱글톤컨테이너_상태공유이슈(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService1 = ac.getBean("orderService", OrderService.class);
        OrderService orderService2 = ac.getBean("orderService", OrderService.class);

        orderService1.order("orderA",500);
        orderService2.order("orderB",2000);

        int priceA = orderService1.getPrice();
        System.err.println(priceA);

        Assertions.assertEquals(priceA,500);    // 500을 기대했지만 2000이 나와서 테스트 실패

        // 해당 객체는 싱글톤으로 관리되므로 orderService2.order()을 통해 먼저 생성된 객체의 값을 덮어쓰게 됨.

    }


    /**
     * 여러 빈에서 다른 공통된 빈을 사용하는 경우 그 공통된 빈은 싱글톤으로 생성되지 않는다.
     */
    @Test
    void Configuration미사용() {

        // 빈으로 등록하는 시점에 memoryMemberRepository 로그가 3번 찍힘.(본인 생성시,orderService생성시,MemberService생성시)
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // 두 repo의 주소 값이 다르다는 테스트
        Assertions.assertNotEquals(memberRepository1.hashCode(),memberRepository2.hashCode());
    }

    @Test
    void Configuration사용() {

        // 빈으로 등록하는 시점에 memoryMemberRepository 로그가 1번 찍힘.(본인 생성시) -> 해당 부분에서 이미 답이 나옴
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // 두 repo의 주소 값이 같다
        Assertions.assertEquals(memberRepository1.hashCode(),memberRepository2.hashCode());
    }

    @Test
    void Configuration유무차이(){
        ApplicationContext ac1 = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ac2 = new AnnotationConfigApplicationContext(AppConfig2.class);

        System.err.println(ac1.getBean(AppConfig.class));
        System.err.println(ac2.getBean(AppConfig2.class));
    }
}
