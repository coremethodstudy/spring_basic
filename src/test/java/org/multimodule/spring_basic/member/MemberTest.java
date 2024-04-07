package org.multimodule.spring_basic.member;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.service.MemberService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : org.multimodule.spring_basic.member
 * fileName       : MemberTest
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
class MemberTest {

    private MemberService memberService;
    private Member vipMember;
    private Member basicMember;
    private ApplicationContext applicationContext;

    @BeforeEach
    void beforeEach() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
        vipMember = new Member(1L, "memberA", Grade.VIP);
        basicMember = new Member(2L, "memberB", Grade.BASIC);
    }

    @AfterEach
    void afterEach() {
        memberService.clear();
    }

    @Test
    @Order(1)
    void 회원가입_테스트() {
        memberService.join(vipMember);
        Member findVipMember = memberService.findMember(vipMember.getId());
        Assertions.assertNotNull(findVipMember);
        Assertions.assertEquals(vipMember.getId(), findVipMember.getId());
        Assertions.assertEquals(vipMember.getGrade(), findVipMember.getGrade());
        Assertions.assertEquals(vipMember.getName(), findVipMember.getName());
    }

}
