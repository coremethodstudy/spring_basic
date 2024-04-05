package org.multimodule.spring_basic.query;

import org.multimodule.spring_basic.command.domain.member.Grade;

public class MemberData {
    private String name;
    private Grade grade;

    public MemberData(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }
}
