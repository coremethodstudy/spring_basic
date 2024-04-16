package org.multimodule.spring_basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonServiceTest {

    @Test
    void 싱글톤객체_사용(){

        // 당연히 private이라 객체 생성 불가
        // new SingletonService();

        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        Assertions.assertEquals(instance1.hashCode(),instance2.hashCode());
        instance1.action();
        instance2.action();
    }


}
