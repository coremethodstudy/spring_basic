package org.multimodule.spring_basic;

import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.member.MemberRepository;
import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    //ComponentScan을 통해 의존관계 자동 주입
    //@Configuration붙은 거는 빼고 하겠다는 뜻
    //컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에,
    //우리는 예제코드 살리기 위해서


    //이러한 컨피그 클래스는 스프링에서만 사용하는 것이니까
    // -> 특수하게 Bean을 수동으로 등록할 때 사용함...근데 다른 더 좋은 방법이 있으니까 그걸 사용하는 것.....
    //필드 주입은 테스트코드에서나 사용하자
//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;

//    @Bean("orderServiceImplTest")
//    OrderService orderService(){
//        return new OrderServiceImpl(memberRepository, discountPolicy); //이렇게.....
//    }

}
