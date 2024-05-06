package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.request.MemberJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody MemberJoin memberJoin) {
        System.out.println(memberJoin.getEmail());
        System.out.println(memberJoin.getPassword());
        System.out.println(memberJoin.getName());
        System.out.println(memberJoin.getPasswordCheck());

        return memberJoin.getEmail();
    }
    @PostMapping("/test")
    @ResponseBody
    public String test() {
        return "완료!";
    }
    @PostMapping("/message")
    public String receiveMessage(@RequestBody String message) {
        System.out.println("클라이언트로부터 받은 메시지: " + message);
        return message; // 받은 메시지를 그대로 응답
    }
}
