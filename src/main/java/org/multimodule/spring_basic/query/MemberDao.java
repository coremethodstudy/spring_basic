package org.multimodule.spring_basic.query;

import org.springframework.stereotype.Component;

@Component
public interface MemberDao {
    MemberData findById(Long memberId);
}
