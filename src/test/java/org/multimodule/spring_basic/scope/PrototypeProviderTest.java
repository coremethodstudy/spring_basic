package org.multimodule.spring_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeProviderTest {

    @Test
    void 프로바이더_어떻게_되는지_볼라고요(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        int count1 = bean1.logic();
        System.out.println(bean1.getPrototypeBean());
        assertThat(count1).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        int count2 = bean2.logic();
        System.out.println(bean2.getPrototypeBean());
        assertThat(count2).isEqualTo(1);

        assertThat(bean1.getPrototypeBean()).isNotSameAs(bean2.getPrototypeBean());

    }
    //지정한 빈을 컨테이너에서 대신 찾아주는 DL 서비스를 제공하는 것이 바로 ObjectProvider ObjectFactory(예전에 쓰던거임)

    static class ClientBean{
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public ClientBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
            this.prototypeBeanProvider = prototypeBeanProvider;
        }

        public PrototypeBean getPrototypeBean(){
            //이렇게 불러내는 것도 다를 프로토 타입을 생성하니까
            //사용하는 프로토타입도 아님 암튼 쓸모없는 코드죠
            return prototypeBeanProvider.getObject();
        }

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
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
