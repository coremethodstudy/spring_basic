package org.multimodule.spring_basic.member.repository;

import org.multimodule.spring_basic.member.Member;

public interface MemberRepository {
    void save(Member member);

    Member findMemberById(Long memberId);
    
}
