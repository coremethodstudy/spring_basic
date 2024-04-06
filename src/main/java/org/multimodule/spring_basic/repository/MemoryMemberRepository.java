package org.multimodule.spring_basic.repository;

import org.multimodule.spring_basic.command.domain.member.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository{

    public static Map<Long, Member> memberStore = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        memberStore.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberStore.get(memberId);
    }
}
