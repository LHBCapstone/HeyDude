package com.lhb.lhbackend.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberJoin {
    private String name;
    private String email;
    private String password;
}
