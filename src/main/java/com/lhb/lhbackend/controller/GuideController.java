package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.border.GetGuides;
import com.lhb.lhbackend.dto.border.RegistGuide;
import com.lhb.lhbackend.dto.member.MemberJoin;
import com.lhb.lhbackend.entity.Guide;
import com.lhb.lhbackend.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guide")
@RequiredArgsConstructor
public class GuideController {
    private final GuideService guideService;

    @PostMapping("/regist")
    public ResponseEntity<String> regist(@RequestBody RegistGuide registGuide) {
        try {
            guideService.regist(registGuide);
            return ResponseEntity.ok(registGuide.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/getGuides")
    public List<Guide> getGuides(){
        return guideService.getGuides();
    }

    @GetMapping("/getGuide/{id}")
    public Guide getGuide(@PathVariable Long id){
        System.out.println("id : "+id + "guide :  "+guideService.getGuide(id));
        return guideService.getGuide(id);
    }

}
