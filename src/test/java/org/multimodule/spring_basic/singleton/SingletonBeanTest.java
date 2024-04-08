package org.multimodule.spring_basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonBeanTest {
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void 싱글톤_빈_싱글톤이_맞을까(){
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//        Object memberService = ac.getBean("memberService");
//        Object memberService1 = ac.getBean("memberService");
        //1. 조회 : 호출할 때 마다 같은 객체를 반환
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //2. 조회 : 호출할 때 마다 같은 객체를 반화
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //참조값이 같은 것을 확인
        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);
        //같은 값이 출력됨
        //memberService1 == memberService
        assertThat(memberService).isSameAs(memberService1);
    }
}
