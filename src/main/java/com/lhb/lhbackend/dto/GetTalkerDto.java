package com.lhb.lhbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class GetTalkerDto {

    private Long toMemberId;
    private String toMemberName;
    private String toMemberEmail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetTalkerDto that = (GetTalkerDto) o;
        return Objects.equals(toMemberId, that.toMemberId) && Objects.equals(toMemberName, that.toMemberName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toMemberId, toMemberName);
    }

}
