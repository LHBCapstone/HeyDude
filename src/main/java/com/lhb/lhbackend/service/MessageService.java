package com.lhb.lhbackend.service;

import com.lhb.lhbackend.dto.*;
import com.lhb.lhbackend.entity.Guide;
import com.lhb.lhbackend.entity.Member;
import com.lhb.lhbackend.entity.Message;
import com.lhb.lhbackend.repository.GuideRepository;
import com.lhb.lhbackend.repository.MemberRepository;
import com.lhb.lhbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {
    MessageRepository messageRepository;
    MemberRepository memberRepository;
    GuideRepository guideRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository, MemberRepository memberRepository, GuideRepository guideRepository) {
        this.messageRepository = messageRepository;
        this.memberRepository = memberRepository;
        this.guideRepository = guideRepository;
    }
    public List<Message> getMessage(String email){
        List<Message> list = new ArrayList<>();
        for(int i = 0 ; i < messageRepository.findAll().size(); i++){
            if(messageRepository.findAll().get(i).getFromMember().getId() == memberRepository.findByEmail(email).getId()){
                list.add(messageRepository.findAll().get(i));
            }
        }
        return list;
    }
    public void sendMessage(MessageDto messageDto){
        Message message = new Message();
        Member toMember = memberRepository.findByEmail(messageDto.getToMember());
        Member fromMember = memberRepository.findByEmail(messageDto.getFromMember());
        message.setContent(messageDto.getContent());
        message.setToMember(toMember);
        message.setFromMember(fromMember);
        messageRepository.save(message);
    }

    public List<GetTalkerDto> getTalker(String email){
        List<GetTalkerDto> list = new ArrayList<>();
        Set<GetTalkerDto> set = new HashSet<>();
        Member fromUser = memberRepository.findByEmail(email);
        for(int i = 0 ; i < messageRepository.findAll().size(); i++){
            if((messageRepository.findAll().get(i).getFromMember().getId() == fromUser.getId()) ||
            (messageRepository.findAll().get(i).getToMember().getId() == fromUser.getId())){
                if(messageRepository.findAll().get(i).getToMember().getEmail().equals(email)){
                    continue;
                }
                GetTalkerDto getTalkerDto = new GetTalkerDto();
                getTalkerDto.setToMemberId(messageRepository.findAll().get(i).getToMember().getId());
                getTalkerDto.setToMemberName(messageRepository.findAll().get(i).getToMember().getName());
                getTalkerDto.setToMemberEmail(messageRepository.findAll().get(i).getToMember().getEmail());
                set.add(getTalkerDto);
            }
        }
        return new ArrayList<>(set);
    }

    public List<GetMessageContentDto> getMessageContent(GetMessageDto getMessageDto) {
        List<GetMessageContentDto> list = new ArrayList<>();
        Optional<Member> toMemberOpt = memberRepository.findById(getMessageDto.getToMemberId());
        Member fromMember = memberRepository.findByEmail(getMessageDto.getFromMemberEmail());

        for(Message message : messageRepository.findAll()){
            GetMessageContentDto dto = new GetMessageContentDto();
            if((message.getFromMember().getId() == fromMember.getId())
            && (message.getToMember().getId() == toMemberOpt.get().getId()) || (
            (message.getToMember().getId() == fromMember.getId()) &&
            (message.getFromMember().getId() == toMemberOpt.get().getId()))
                    ) {

                dto.setContent(message.getContent());
                dto.setToMemberEmail(message.getToMember().getEmail());
                dto.setToMemberId(message.getToMember().getId());
                dto.setFromMemberId(message.getFromMember().getId());
                list.add(dto);
            }
        }
        return list;
    }

    public int reserve(int status, ReservationDto reservationDto){
        List<Guide> list = guideRepository.findAll();
        Guide guide = new Guide();
        for(Guide gay: list){
            if(gay.getId().equals(reservationDto.getGuideId())){
                guide = gay;
            }
        }
        guide.setReservedFromMember(reservationDto.getFromMember());
        guide.setReservedToMember(reservationDto.getToMember());
        guide.setReservation(1);
        guideRepository.save(guide);

        return 1;
    }
}