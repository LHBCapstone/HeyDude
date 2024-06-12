package com.lhb.lhbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.lhbackend.dto.member.MemberCheckEmail;
import com.lhb.lhbackend.dto.member.MemberJoin;
import com.lhb.lhbackend.dto.member.MemberLogin;
import com.lhb.lhbackend.repository.MemberRepository;
import com.lhb.lhbackend.entity.Member;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void signup(MemberJoin memberJoin) {
        Member member = new Member();
        member.setEmail(memberJoin.getEmail());
        member.setName(memberJoin.getName());
        member.setPassword(memberJoin.getPassword());
        member.setPoint(3000);
        memberRepository.save(member);
    }


    public boolean logable(MemberLogin memberLogin) {
        Member member = memberRepository.findByEmail(memberLogin.getEmail());
        return member != null && member.getPassword().equals(memberLogin.getPassword());
    }


    public boolean checkEmail(MemberCheckEmail email) {
        Member member = memberRepository.findByEmail(email.getEmail());
        return member != null;
    }

    // 모든 회원 정보를 반환하는 메서드
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    //이름 변경 메서드
    public void changeName(Member mem, String name){
        Member member = memberRepository.findByEmail(mem.getEmail());
        member.setName(name);
        memberRepository.save(member);
    }

    //비밀번호 변경 메서드
    public void changePassword(Member mem, String password) {
        Member member = memberRepository.findByEmail(mem.getEmail());
        member.setPassword(password);
        memberRepository.save(member);
    }
}