//package org.multimodule.spring_basic.command.application;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.multimodule.spring_basic.command.domain.member.Grade;
//import org.multimodule.spring_basic.config.AppConfig;
//import org.multimodule.spring_basic.query.MemberData;
//
//class RateDiscountPolicyTest {
//
//    DiscountPolicy discountPolicy;
//
//    @BeforeEach
//    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
//        discountPolicy = appConfig.discountPolicy();
//    }
//
//    @Test
//    void VIP_할인율_적용() {
//        //given
//        MemberData memberData = new MemberData("김아무개", Grade.VIP);
//
//        //when
//        int discount = discountPolicy.discountByGrade(memberData, 10000);
//
//        //then
//        Assertions.assertThat(discount).isEqualTo(1000);
//    }
//
//    @Test
//    void VIP_아님_할인율_미적용() {
//        //given
//        MemberData memberData = new MemberData("김아무개", Grade.BASIC);
//
//        //when
//        int discount = discountPolicy.discountByGrade(memberData, 10000);
//
//        //then
//        Assertions.assertThat(discount).isEqualTo(0);
//    }
//}