package org.multimodule.spring_basic.beanfind;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.discount.impl.FixDiscountPolicy;
import org.multimodule.spring_basic.discount.impl.RateDiscountPolicy;
import org.multimodule.spring_basic.member.repository.MemberRepository;
import org.multimodule.spring_basic.member.repository.impl.MemoryMemberRepositoryImpl;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * packageName    : org.multimodule.spring_basic.beanfind
 * fileName       : ApplicationContextSameBeanFindTest
 * author         : AngryPig123
 * date           : 2024-04-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-07        AngryPig123       최초 생성
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicationContextExtendsFindTest {

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new AnnotationConfigApplicationContext(TestConfig.class);
    }

    @Test
    @Order(1)
    void 부모_타입_조회_중복_테스트() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(DiscountPolicy.class);
        });
    }

    @Test
    @Order(2)
    void 부모_타입_조회_중복_이름_지정_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        });
        DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        Assertions.assertInstanceOf(RateDiscountPolicy.class, bean);
    }

    @Test
    @Order(3)
    void 부모_타입_조회_중복_타입_지정_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            ac.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        });
        DiscountPolicy bean = ac.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        Assertions.assertInstanceOf(RateDiscountPolicy.class, bean);
    }

    @Test
    @Order(4)
    void 부모_타입_전체_조회() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        Assertions.assertEquals(2, beansOfType.size());
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " implements class = " + beansOfType.get(key));
        }
    }

    @Test
    @Order(5)
    void 오브젝트_타입_전체_조회() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " implements class = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

}
