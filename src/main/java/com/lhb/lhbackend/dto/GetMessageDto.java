package com.lhb.lhbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetMessageDto {
    private Long toMemberId;
    private String fromMemberEmail;
}
