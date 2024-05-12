package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.request.MemberJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody MemberJoin memberJoin) {
        System.out.println(memberJoin.getEmail());
        System.out.println(memberJoin.getPassword());
        System.out.println(memberJoin.getName());
        System.out.println(memberJoin.getPasswordCheck());

        return memberJoin.getEmail();
    }
    @GetMapping("/test")
    public String test(@RequestBody String say) {
        return "완료!"+say;
    }

    @GetMapping("/message")
    public String receiveMessage() {
        return "hijun"; // 받은 메시지를 그대로 응답
    }
    @PostMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(@RequestParam String email) {
        System.out.println(email);
        return email;
    }
}
