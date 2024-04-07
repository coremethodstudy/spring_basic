package org.multimodule.spring_basic.xml;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.beanfind.ApplicationContextExtendsFindTest;
import org.multimodule.spring_basic.member.service.MemberService;
import org.multimodule.spring_basic.order.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * packageName    : org.multimodule.spring_basic.xml
 * fileName       : XmlAppContext
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class XmlAppContext {

    private GenericXmlApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new GenericXmlApplicationContext("appConfig.xml");
    }

    @Test
    @Order(1)
    void XML_설정() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertNotNull(memberService);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Assertions.assertNotNull(orderService);
    }

}
