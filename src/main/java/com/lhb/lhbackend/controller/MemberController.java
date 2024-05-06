package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.request.MemberJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {
    @PostMapping("/signup")
    public String signup(@RequestBody MemberJoin memberJoin) {
        System.out.println(memberJoin.getEmail());
        System.out.println(memberJoin.getPassword());
        System.out.println(memberJoin.getName());
        System.out.println(memberJoin.getPasswordCheck());
        return "회원가입 성공";
    }
}
