package com.lhb.lhbackend.service;

import java.util.ArrayList;

import com.lhb.lhbackend.dto.request.member.MemberCheckEmail;
import com.lhb.lhbackend.dto.request.member.MemberJoin;
import com.lhb.lhbackend.dto.request.member.MemberLogin;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public boolean logable(MemberLogin memberLogin, ArrayList<MemberJoin> memberList) {
        for(MemberJoin memberJoin : memberList) {
            if(memberLogin.getEmail().equals(memberJoin.getEmail())) {
                if(memberLogin.getPassword().equals(memberJoin.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkEmail(MemberCheckEmail email, ArrayList<MemberJoin> memberList) {
        for(MemberJoin memberJoin : memberList) {
            if(email.getEmail().equals(memberJoin.getEmail())) {
                return true;
            }
        }
        return false;
    }

}
