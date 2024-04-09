package org.multimodule.spring_basic.member.repository.impl;

import org.multimodule.spring_basic.member.Member;
import org.multimodule.spring_basic.member.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepositoryImpl implements MemberRepository {

    public static final Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return store.get(memberId);
    }

}
