package org.multimodule.spring_basic.command.application;

import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.repository.MemberRepository;
import org.multimodule.spring_basic.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
