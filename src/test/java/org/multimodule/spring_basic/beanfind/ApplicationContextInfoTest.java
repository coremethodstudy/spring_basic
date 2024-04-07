package org.multimodule.spring_basic.beanfind;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : org.multimodule.spring_basic
 * fileName       : ApplicationContextInfoTest
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationContextInfoTest {

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    @Order(1)
    void 모든_bean_조회() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @Order(2)
    void 애플리케이션_bean_조회() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + beanDefinitionName + " object = " + bean);
            }
        }
    }

}
