package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.member.*;
import com.lhb.lhbackend.entity.Member;
import com.lhb.lhbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody MemberJoin memberJoin) {
        try {
            memberService.signup(memberJoin);
            return ResponseEntity.ok(memberJoin.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberLogin memberLogin) {
        if (memberService.logable(memberLogin)) {
            return ResponseEntity.ok(memberLogin.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 올바르지 않습니다.");
        }
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestBody MemberCheckEmail email) {
        if (!memberService.checkEmail(email)) {
            return ResponseEntity.ok(email.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이미 사용중인 이메일 입니다.");
        }
    }

    @GetMapping("/userList")
    @ResponseBody
    public ResponseEntity<List<Member>> getMemberList() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @PostMapping("/profile")
    public ResponseEntity<Member> profile(@RequestBody MemberCheckEmail email) {
        Member member = memberService.findByEmail(email.getEmail());
        return ResponseEntity.ok(member);
    }

    @PostMapping("/changeName")
    public void changeName(@RequestBody MemberChangeName memberChangeName) {
        Member member = memberService.findByEmail(memberChangeName.getEmail());
        memberService.changeName(member, memberChangeName.getName());
    }
    //이름 받아와서 이미 저장된 이름이면 변경 불가하도록 badRequest보내야 함

    @PostMapping("/changePw")
    public void changePw(@RequestBody MemberChangePw memberChangePw) {
        Member member = memberService.findByEmail(memberChangePw.getEmail());
        memberService.changePassword(member, memberChangePw.getPassword());
    }
    //이미 사용중인 패스워드면 안바꿔줌
}