package org.multimodule.spring_basic.query;

public interface MemberDao {
    MemberData findById(Long memberId);
}
