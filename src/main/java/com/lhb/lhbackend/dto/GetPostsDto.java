package com.lhb.lhbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPostsDto {
    private Long guideId;
    private String title;
    private String fromMemberEmail;
    private int reservation;
}
