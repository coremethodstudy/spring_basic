package org.multimodule.spring_basic.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : org.multimodule.spring_basic.singleton
 * fileName       : SingleTest
 * author         : AngryPig123
 * date           : 2024-04-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-13        AngryPig123       최초 생성
 */
public class SingleTest {

    private AppConfig appConfig;

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        appConfig = new AppConfig();
        ac = new AnnotationConfigApplicationContext(appConfig.getClass());
    }

    @Test
    void 스프링_없는_순수한_DI_컨테이너() {
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        Assertions.assertNotSame(memberService1, memberService2);
    }

    @Test
    void 스프링_있는_DI_컨테이너() {
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        Assertions.assertSame(memberService1, memberService2);
    }

    @Test
    void 싱글톤_테스트() {
        SingleTonService instance1 = SingleTonService.getInstance();
        SingleTonService instance2 = SingleTonService.getInstance();
        Assertions.assertSame(instance1, instance2);
    }

}
