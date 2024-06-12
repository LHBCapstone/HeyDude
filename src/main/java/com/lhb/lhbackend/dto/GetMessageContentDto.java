package com.lhb.lhbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMessageContentDto {
    private Long toMemberId;
    private Long fromMemberId;
    private String content;
    private String toMemberEmail;
}
