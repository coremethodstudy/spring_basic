package org.multimodule.spring_basic.member;

public class MemberServiceImpl implements MemberService{

    //이렇게 적으면 MemberServiceImpl는 추상화MemberRepository에도 의존하고 구체화MemoryMemberRepository에도 의존한다
    //안 좋음 DIP 위반임
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

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
}
