package org.multimodule.spring_basic.beandefinition;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : org.multimodule.spring_basic.beandefinition
 * fileName       : BeanDefinitionTest
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnnotationBeanDefinitionTest {

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    @Order(1)
    void 빈_설정_메타정보_확인() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition" + beanDefinition);
            }
        }
    }

}
