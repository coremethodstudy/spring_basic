package org.multimodule.spring_basic.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.multimodule.spring_basic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class XmlAppContextTest {
    //xml appConfig 만들어서 해봄
    //그냥 이렇게도 한다는 것만 알고 넘어가자 뭐 없음
    //넘어 가겠음
    @Test
    void xmlAppContext(){
        //GenericXmlApplicationContext xml을 읽을 때 사용하는 것임
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
