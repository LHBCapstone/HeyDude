package com.lhb.lhbackend.service;

import com.lhb.lhbackend.dto.MessageDto;
import com.lhb.lhbackend.entity.Member;
import com.lhb.lhbackend.entity.Message;
import com.lhb.lhbackend.repository.MemberRepository;
import com.lhb.lhbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    MessageRepository messageRepository;
    MemberRepository memberRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository, MemberRepository memberRepository) {
        this.messageRepository = messageRepository;
        this.memberRepository = memberRepository;
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
}
