package org.multimodule.spring_basic.beanfind;

import org.junit.jupiter.api.*;
import org.multimodule.spring_basic.AppConfig;
import org.multimodule.spring_basic.member.repository.MemberRepository;
import org.multimodule.spring_basic.member.repository.impl.MemoryMemberRepositoryImpl;
import org.multimodule.spring_basic.member.service.MemberService;
import org.multimodule.spring_basic.member.service.impl.MemberServiceImpl;
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
public class ApplicationContextSameBeanFindTest {

    private AnnotationConfigApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    }

    @Test
    @Order(1)
    void 빈_중복_테스트() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(MemberRepository.class);
        });
    }

    @Test
    @Order(2)
    void 빈_특정_타입_전체_조회_테스트() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " implements class = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberService1() {
            return new MemoryMemberRepositoryImpl();
        }

        @Bean
        public MemberRepository memberService2() {
            return new MemoryMemberRepositoryImpl();
        }
    }

}
