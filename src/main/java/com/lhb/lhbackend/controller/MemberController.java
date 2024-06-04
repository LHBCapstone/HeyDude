package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.request.member.MemberCheckEmail;
import com.lhb.lhbackend.dto.request.member.MemberJoin;
import com.lhb.lhbackend.dto.request.member.MemberLogin;
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
    public ResponseEntity<String> profile(@RequestBody MemberCheckEmail email) {
        Member member = memberService.findByEmail(email.getEmail());
        if (member != null) {
            return ResponseEntity.ok(member.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("정보 없음");
        }
    }

    /*@PostMapping("/changeName")
    public ResponseEntity<MemberJoin> changeName(@RequestBody MemberJoin name) {
        for( MemberJoin memberJoin : memberList){
            if(memberJoin.getEmail().equals(name.getEmail())){
                memberJoin.setName(name.getName());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(name);
    }*/
}