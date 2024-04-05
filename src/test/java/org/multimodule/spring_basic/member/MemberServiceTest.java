package org.multimodule.spring_basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.command.domain.member.Grade;
import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.command.application.MemberService;
import org.multimodule.spring_basic.command.application.MemberServiceImpl;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void 멤버_회원가입_객체_일치() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}