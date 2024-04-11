package org.multimodule.spring_basic;

import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.discount.FixDiscountPolicy;
import org.multimodule.spring_basic.discount.RateDiscountPolicy;
import org.multimodule.spring_basic.member.MemberRepository;
import org.multimodule.spring_basic.member.MemberService;
import org.multimodule.spring_basic.member.MemberServiceImpl;
import org.multimodule.spring_basic.member.MemoryMemberRepository;
import org.multimodule.spring_basic.order.OrderService;
import org.multimodule.spring_basic.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //메서드 명에서 역할이 드러나게 리팩터링 해준다
    

    //이렇게 하면 MemberService를 사용할때 MemoryMemberRepository를 사용할 수 있게 함
    //즉 MemberServiceImpl에서는 MemoryMemberRepository를 알 수 없다
    //생성자를 통해서 주입하는 것임 이것이!!!!!!!!!!!!생성자 주입!!!!!!!!!!!!!!!!!!!!

//   @Bean memberService → MemoryMemberRepository()
//   @Bean orderService → MemoryMemberRepository()

//    @Autowired MemberRepository memberRepository; //이렇게해서 문제를 해결하기도 한다

    @Bean
    public MemberService memberService(){
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    //리팩터링 단축키 ctrl alt M
    @Bean
    public MemberRepository memberRepository() {
        //2번? 3번?
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();

//        if(memoryMemberRepository가 이미 스프링 컨테이너에 등록되어 있으면?){
//            return 스프링 컨테이너에서 찾아서 반환;
//        }else{ //스프링 컨테이너에 없으면
//            기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
//            return 반환
//        }

    }

    @Bean
    public OrderService orderService(){
        //1번
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //이렇게 할인 정책을 변경해도 클라이언트는 수정할 필요가 없다!!!
    @Bean
    @Qualifier("mainDiscountPolicy")
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
