package org.multimodule.spring_basic.query;

import org.multimodule.spring_basic.command.domain.member.Member;
import org.multimodule.spring_basic.query.MemberDao;
import org.multimodule.spring_basic.query.MemberData;
import org.springframework.stereotype.Component;

import static org.multimodule.spring_basic.repository.MemoryMemberRepository.memberStore;

@Component
public class MemoryMemberDao implements MemberDao {
    @Override
    public MemberData findById(Long memberId) {
        Member member = memberStore.get(memberId);
        MemberData memberData = new MemberData(member.getName(), member.getGrade());
        return memberData;
    }
}
