package org.multimodule.spring_basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingltonServiceTest {
//    private SingletonService singletonService; 이거는 필요없는 코드임 맞음 왜 적었는지 반성 중....
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void 싱글톤_호출(){
        //new SingletonService로 하면 컴파일 에러남 - 세상에서 젤 좋은 컴파일 에러~!~!~!

        //1. 조회 : 호출할 때 마다 같은 객체 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        //2. 조회 : 호출할 때 마다 같은 객체 반환
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        //singletonService2 == singletonService1
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        //isSameAs == 을 비교
        //isEqual equal이란 뜻

        singletonService1.logic();
        singletonService2.logic();
        //스프링 컨테이너가 싱글톤으로 관리는 해준다!!!!!!ㄷㄷㄷㄷㄷ
    }
}
