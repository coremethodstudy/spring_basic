package org.multimodule.spring_basic.autowired.allBean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.AutoAppConfig;
import org.multimodule.spring_basic.discount.DiscountPolicy;
import org.multimodule.spring_basic.member.Grade;
import org.multimodule.spring_basic.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @Test
    void findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService bean = ac.getBean(DiscountService.class);
        Member member = new Member(3L, "member", Grade.VIP);

        int discountPrice = bean.discountPrice(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discountPrice).isEqualTo(1000);

    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }


        public int discountPrice(Member member, int price, String discountPolicy) {
            DiscountPolicy discountPolicy1 = policyMap.get(discountPolicy);
            int discount = discountPolicy1.discount(member, price);

            return discount;
        }
    }
}
