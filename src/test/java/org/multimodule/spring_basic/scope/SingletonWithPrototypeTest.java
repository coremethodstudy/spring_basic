package org.multimodule.spring_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest {

    @Test
    void 싱글톤프로토타입_어떻게_되는지_볼라고요(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        int count1 = bean1.logic();
        System.out.println(bean1.getPrototypeBean());
        assertThat(count1).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        int count2 = bean2.logic();
        System.out.println(bean2.getPrototypeBean());
        assertThat(count2).isEqualTo(2);

        assertThat(bean1.getPrototypeBean()).isSameAs(bean2.getPrototypeBean());
        //싱글톤이 생서될 때 프로토 타입이 생성되고 이것을 계속 사용하니까 주소가 같음..
        //프로토 타입은 항상 새로 생성해서 사용해야 의미가 있는데 -> Provider로 문제 해결

        //isEqualTo 동일한 내용을 가지고 있는지 비교
        //isSameAs 참조가 같은지 비교 주소비교?
    }

    static class ClientBean{
        private final PrototypeBean prototypeBean;
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public PrototypeBean getPrototypeBean(){
            return prototypeBean;
        }

        public int logic(){
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy ");
        }

    }
}
