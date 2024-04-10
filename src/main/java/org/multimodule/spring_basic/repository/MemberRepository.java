package org.multimodule.spring_basic.repository;


import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
