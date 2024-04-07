package org.multimodule.spring_basic.beanfind;


import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.service.MemberService;
import org.multimodule.spring_basic.member.service.impl.MemberServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : org.multimodule.spring_basic.beanfind
 * fileName       : ApplicationContextBasicFindTest
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicationContextBasicFindTest {

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    @Order(1)
    void 빈_이름_타입_으로_조회() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @Order(2)
    void 빈_타입으로_조회() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @Order(3)
    void 빈_이름으로_조회() {
        Object memberService = ac.getBean("memberService");
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @Order(4)
    void 빈_구현체로_조회() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

}
