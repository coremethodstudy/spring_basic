package org.multimodule.spring_basic.scan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.SpringBasicApplication;
import org.multimodule.spring_basic.member.service.MemberService;
import org.multimodule.spring_basic.order.service.OrderService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * packageName    : org.multimodule.spring_basic.scan
 * fileName       : AutoAppConfigTest
 * author         : AngryPig123
 * date           : 2024-04-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-14        AngryPig123       최초 생성
 */

@SpringBootTest
public class AutoAppConfigTest {

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new AnnotationConfigApplicationContext(SpringBasicApplication.class);
    }

    @Test
    void basicScan() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertNotNull(memberService);

        OrderService orderService = ac.getBean(OrderService.class);
        Assertions.assertNotNull(orderService);
    }

}
