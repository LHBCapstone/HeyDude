package com.lhb.lhbackend.dto.request.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberChangeName {
    private String email;
    private String name;
}
