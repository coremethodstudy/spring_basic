package org.multimodule.spring_basic.repository;


import org.multimodule.spring_basic.command.domain.member.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
