package org.multimodule.spring_basic.member.service.impl;

import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.repository.MemberRepository;
import org.multimodule.spring_basic.member.service.MemberService;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findMemberById(memberId);
    }

    @Override
    public void clear() {
        memberRepository.clear();
    }
    
}
