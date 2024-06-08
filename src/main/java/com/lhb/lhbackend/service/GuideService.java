package com.lhb.lhbackend.service;

import com.lhb.lhbackend.dto.border.GetGuides;
import com.lhb.lhbackend.dto.border.RegistGuide;
import com.lhb.lhbackend.entity.Guide;
import com.lhb.lhbackend.entity.Member;
import com.lhb.lhbackend.repository.GuideRepository;
import com.lhb.lhbackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuideService {
    private final GuideRepository guideRepository;
    private final MemberRepository memberRepository;
    public GuideService(GuideRepository guideRepository, MemberRepository memberRepository) {
        this.guideRepository = guideRepository;
        this.memberRepository = memberRepository;
    }

    public void regist(RegistGuide registGuide){
        Guide guide = new Guide();
        Member member = memberRepository.findByEmail(registGuide.getEmail());
        guide.setTitle(registGuide.getTitle());
        guide.setContent(registGuide.getContent());
        guide.setPrice(registGuide.getPrice());
        guide.setMember(member);
        guideRepository.save(guide);
    }

    public List<Guide> getGuides(){
        List<Guide> guides = new ArrayList<>();
        guides = guideRepository.findAll();
        return guides;
    }

    public Guide getGuide(Long id){
        Optional<Guide> optionalGuide = guideRepository.findById(id);
        return optionalGuide.orElse(null); // orElse를 사용하여 값이 없을 경우 null 반환
    }

}
