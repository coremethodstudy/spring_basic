package org.multimodule.spring_basic.order;

import lombok.RequiredArgsConstructor;
import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.discount.FixDiscountPolicy;
import org.multimodule.spring_basic.discount.RateDiscountPolicy;
import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.MemberRepository;
import org.multimodule.spring_basic.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor //아주 간단한 방법
public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //이렇게 하면 이제 DIP는 지킨 것....그런데 구체클래스를 어떻게 주입을 해줄까..? 다음시간에.....
//    private DiscountPolicy discountPolicy;

    //DIP를 지켜서 구체클래스를 주입하는 방법
    //생성자를 통해서 주입한다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //필드 주입 쓰지 마세용

//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    //수정자
    //@Autowired 빼면 주입이 안됨
//    @Autowired(required = false) //빈에 없으면 등록하지 않아도 된다는 뜻임 선택적으로 등록할때 사용
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("2discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("2memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

    //    @Autowired
    //스프링도 new OrderServiceImpl(memberRepository, discountPolicy); 해서 생성해서 빈에 등록한다
    public OrderServiceImpl(MemberRepository memberRepository,@Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        //이렇게 찍어서 확인 가능함...
        //요즘 새로운 것을 많이 알아가고 있다 상당히 재밌음
        //@Autowired 생성자에 붙여서 주입.. 생성자 1개만 있으면 생략 가능
        System.out.println("1memberRepository = " + memberRepository);
        System.out.println("1discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //싱글톤 검증 코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }



    //점점 지저분해지는 코드
}
