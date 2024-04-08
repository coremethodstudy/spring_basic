package org.multimodule.spring_basic;

import org.multimodule.spring_basic.config.AppConfig;
import org.multimodule.spring_basic.command.application.MemberService;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member.getName() = " + member.getName());
        System.out.println("findMember.getName() = " + findMember.getName());
    }
}
