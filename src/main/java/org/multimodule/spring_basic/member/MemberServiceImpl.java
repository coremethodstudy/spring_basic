package org.multimodule.spring_basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MemberServiceImpl implements MemberService{

    //이렇게 적으면 MemberServiceImpl는 추상화MemberRepository에도 의존하고 구체화MemoryMemberRepository에도 의존한다
    //안 좋음 DIP 위반임
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

//    @Autowired //ac.getBean("member
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //싱글톤 검증 코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
