package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}
