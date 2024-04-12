package org.multimodule.spring_basic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class NetworkClientTest {

    @Test
    void 생명주기_콜백(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient bean = ac.getBean(NetworkClient.class);
        bean.disconnect();//스프링 컨테이너 종료

        //ConfigurableApplicationContext 필요 뭐가 이상하다는 건지 잘 찍히는데 음 그렇군요
//        생성자 호출...뭐하는지 url = null
//        connect : null
//        call: null message = 초기화 연결 메시지
//        disconnect : http://hroesZZang.v1
        //이거 보세요 setUrl을 해야지 주소가 주입됩니다....좀 이상하죠...?

        //초기화 작업은 의존관계 주입이 다 끝이나고 호출해야 한다.

    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hroesZZang.v1");
            return networkClient;
        }
    }

}