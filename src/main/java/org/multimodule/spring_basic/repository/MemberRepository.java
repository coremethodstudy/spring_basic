package org.multimodule.spring_basic.repository;


import org.multimodule.spring_basic.command.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long memberId);
}
