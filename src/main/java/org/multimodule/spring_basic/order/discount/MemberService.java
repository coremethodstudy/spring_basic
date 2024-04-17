package org.multimodule.spring_basic.order.discount;

import lombok.Getter;
import org.multimodule.spring_basic.order.MemberRepository;

public class MemberService {

    @Getter
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

}
