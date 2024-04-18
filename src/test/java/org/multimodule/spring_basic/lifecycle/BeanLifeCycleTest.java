package org.multimodule.spring_basic.lifecycle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class BeanLifeCycleTest {


    private AnnotationConfigApplicationContext ac1;
    private AnnotationConfigApplicationContext ac2;
    private AnnotationConfigApplicationContext ac3;

    @BeforeEach
    void beforeEach() {
        ac1 = new AnnotationConfigApplicationContext(LifeCycleConfig1.class);
        ac2 = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
        ac3 = new AnnotationConfigApplicationContext(LifeCycleConfig3.class);
    }

    @AfterEach
    void afterEach() {
        ac1.close();
    }

    @Test
    void lifeCycleTest() {
        NetworkClient1 netWorkClient1 = ac1.getBean("networkClient1", NetworkClient1.class);
        NetworkClient2 netWorkClient2 = ac2.getBean("networkClient2", NetworkClient2.class);
        NetworkClient3 netWorkClient3 = ac3.getBean("networkClient3", NetworkClient3.class);
    }

    @Configuration
    static class LifeCycleConfig1 {
        @Bean
        public NetworkClient1 networkClient1() {
            NetworkClient1 networkClient1 = new NetworkClient1();
            networkClient1.setUrl("google.com");
            return networkClient1;
        }
    }

    @Configuration
    static class LifeCycleConfig2 {
        @Bean(initMethod = "init", destroyMethod = "destroy")
        public NetworkClient2 networkClient2() {
            NetworkClient2 networkClient2 = new NetworkClient2();
            networkClient2.setUrl("google.com");
            return networkClient2;
        }
    }

    @Configuration
    static class LifeCycleConfig3 {
        @Bean
        public NetworkClient3 networkClient3() {
            NetworkClient3 networkClient3 = new NetworkClient3();
            networkClient3.setUrl("google.com");
            return networkClient3;
        }
    }

}
