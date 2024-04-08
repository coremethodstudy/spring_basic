package org.multimodule.spring_basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest {
    //Ctrl shift t -> 테스트 만들기
    @Test
    void 싱글톤_문제상황_한번볼까요(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        statefulService.order("userA", 10000);
        //ThreadB : B사용자 20000원 주문
        statefulService1.order("userB", 20000);

        //지역변수로 바꾼거임 이렇게 //////////////////////////////////////////////
        int priceOrder = statefulService.order1("userA", 10000);
        int priceOrder1 = statefulService1.order1("userB", 20000);
        System.out.println("priceOrder = " + priceOrder);
        /////////////////////////////////////////////////////////////////////////

        //ThreadA : 사용자A 주문 금액 조회
        int price = statefulService.getPrice();
        //ThreadA : 사용자A는 10000원을 기대했지만 기대화 다르게 20000원 출력
        System.out.println("price = " + price);

        assertThat(statefulService.getPrice()).isEqualTo(20000);

        //잘못하면 나의 아이디에 다른 사람 아이디가 보이거나 이럼 복구하는데 몇달 걸림
        //이런거 멀티 스레드 문제.. 암튼 주의하자~!
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
