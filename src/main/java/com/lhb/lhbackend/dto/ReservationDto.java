package com.lhb.lhbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationDto {
    private String toMember;
    private String fromMember;
    private Long guideId;
}
