package org.multimodule.spring_basic.order;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.service.MemberService;
import org.multimodule.spring_basic.order.service.OrderService;

/**
 * packageName    : org.multimodule.spring_basic.order
 * fileName       : OrderTest
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderTest {

    private MemberService memberService;
    private OrderService orderService;
    private Member vipMember;
    private Member basicMember;

    private final AppConfig appConfig = new AppConfig();

    @BeforeEach
    void beforeEach() {
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

        vipMember = new Member(1L, "memberA", Grade.VIP);
        basicMember = new Member(2L, "memberB", Grade.BASIC);

        memberService.join(vipMember);
        memberService.join(basicMember);
    }

    @AfterEach
    void afterEach() {
        memberService.clear();
    }

    @Test
    void VIP_주문_테스트() {
        Order vipMemberPrice_10_000 = orderService.createOrder(vipMember.getId(), "itemA", 10000);
        Assertions.assertEquals(1000, vipMemberPrice_10_000.getDiscountPrice());

        Order basicMemberPrice_10_000 = orderService.createOrder(basicMember.getId(), "itemA", 10000);
        Assertions.assertEquals(0, basicMemberPrice_10_000.getDiscountPrice());
    }

}