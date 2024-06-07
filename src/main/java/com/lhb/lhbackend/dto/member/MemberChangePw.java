package com.lhb.lhbackend.dto.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberChangePw {
    private String email;
    private String password;
}
