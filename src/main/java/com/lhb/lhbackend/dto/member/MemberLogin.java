package com.lhb.lhbackend.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberLogin {
    private String email;
    private String password;
}
