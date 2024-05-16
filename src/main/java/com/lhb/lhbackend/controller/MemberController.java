package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.request.MemberCheckEmail;
import com.lhb.lhbackend.dto.request.MemberJoin;
import com.lhb.lhbackend.dto.request.MemberLogin;
import com.lhb.lhbackend.entity.Member;
import com.lhb.lhbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@RestController
//public class MemberController {
//
//    @GetMapping("/user/message")
//    public String getMessage() {
//        return "Hello from Spring Boot!";
//    }
//}
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {
    public ArrayList<MemberJoin> memberList = new ArrayList<>();
    MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody MemberJoin memberJoin) {
        try{
            memberList.add(memberJoin);
            return ResponseEntity.ok(memberJoin.toString());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberLogin memberLogin){
        if(memberService.logable(memberLogin, memberList)) {
            return ResponseEntity.ok(memberLogin.toString());
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 올바르지 않습니다.");
        }
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestBody MemberCheckEmail email) {
        if(!memberService.checkEmail(email, memberList)){
            return ResponseEntity.ok(email.toString()) ;
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이미 사용중인 이메일 입니다.");
        }
    }

    @GetMapping("/userList")
    @ResponseBody
    public ResponseEntity<ArrayList<MemberJoin>> getMemberList(){
        return ResponseEntity.ok(memberList);
    }
}
