package org.multimodule.spring_basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.MemberRepository;
import org.multimodule.spring_basic.member.MemberService;
import org.multimodule.spring_basic.member.MemberServiceImpl;
import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    @Test
    void 컨피그레이션_싱글톤_확인(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //memberService 에 MemberServiceImpl(memberRepository)를 넣어준건데... 어떻게 꺼내지
        //객체타입을 MemberServiceImpl이럭로 해야함....아나 - get꺼낼라고 그러는거임 - 원래는 이렇게 구체타입 꺼내면 안좋음
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        //모두 같은 인스턴스를 참고하고 있다
        System.out.println("memberService => memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService => memberRepository =  " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //AnnotationConfigApplicationContext에 파라미터로 넘긴 AppConfig도 스프링 빈으로 등록된다
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
        //출력 - bean = org.multimodule.spring_basic.AppConfig$$SpringCGLIB$$0@d8305c2
        //만약 순수한 클래스라면 class org.multimodule.spring_basic.AppConfig 로 출력됨
        //하지만 출력물은 xxxCGLIB가 붙은 복잡한 것
        //이거는 내가 만든 클래스가 아니라 스프링이 CGLIB 라는 바이트코드 조작 라이브러리를 사용
        //AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고 -> 그 다른 클래스를 스프링 빈으로 등록한 것!!!!!!
    }
}
