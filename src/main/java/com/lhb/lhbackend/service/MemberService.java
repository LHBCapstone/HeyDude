package com.lhb.lhbackend.service;

import java.util.ArrayList;
import java.util.List;

import com.lhb.lhbackend.dto.request.MemberJoin;
import com.lhb.lhbackend.dto.request.MemberLogin;
import com.lhb.lhbackend.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private List<MemberJoin> memberList = new ArrayList<>();
    private String email = "admin";
    private String password = "1234";

    public boolean logable(MemberLogin memberLogin, ArrayList<MemberJoin> memberList) {
        for(MemberJoin memberJoin : memberList) {
            if(memberLogin.getEmail().equals(memberJoin.getEmail())) {
                if(memberLogin.getPassword().equals(memberJoin.getPassword())) {
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean checkEmail(String email, ArrayList<MemberJoin> memberList) {
        for(MemberJoin memberJoin : memberList) {
            if(email.equals(memberJoin.getEmail())) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
