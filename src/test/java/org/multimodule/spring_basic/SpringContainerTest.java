package org.multimodule.spring_basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.config.AppConfig;
import org.multimodule.spring_basic.order.OrderService;
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
}
