package com.lhb.lhbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private String content;
    private String toMember;
    private String fromMember;
}
