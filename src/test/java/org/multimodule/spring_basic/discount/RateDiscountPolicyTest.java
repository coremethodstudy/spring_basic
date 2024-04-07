package org.multimodule.spring_basic.discount;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.discount.impl.RateDiscountPolicy;
import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : org.multimodule.spring_basic.discount.impl
 * fileName       : RateDiscountPolicyTest
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RateDiscountPolicyTest {

    private RateDiscountPolicy rateDiscountPolicy;
    private Member vipMember;
    private Member basicMember;
    private ApplicationContext applicationContext;

    @BeforeEach
    void beforeEach() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        vipMember = new Member(1L, "memberA", Grade.VIP);
        basicMember = new Member(2L, "memberB", Grade.BASIC);
    }

    @Test
    @Order(1)
    void 정률_할인_테스트() {
        int vipDiscount = rateDiscountPolicy.discount(vipMember, 10000);
        Assertions.assertEquals(1000, vipDiscount);
        int basicDiscount = rateDiscountPolicy.discount(basicMember, 10000);
        Assertions.assertEquals(0, basicDiscount);
    }

}