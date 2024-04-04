package org.multimodule.spring_basic.member.service;

import org.multimodule.spring_basic.member.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);

    void clear();
}