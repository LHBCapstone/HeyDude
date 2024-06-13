package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.*;
import com.lhb.lhbackend.entity.Guide;
import com.lhb.lhbackend.entity.Message;
import com.lhb.lhbackend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class MessageController {
    MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping("/getMessage/{email}")
    public List<Message> getMessage(@PathVariable String email) {
        return messageService.getMessage(email);
    }
    @PostMapping("/getMessageContent")
    public List<GetMessageContentDto> getMessageContent(@RequestBody GetMessageDto getMessageDto){
        return messageService.getMessageContent(getMessageDto);
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto);
    }

    @GetMapping("getTalker/{fromUser}")
    public List<GetTalkerDto> getTalker(@PathVariable String fromUser) {
        return messageService.getTalker(fromUser);
    }

    @PostMapping("/requestRes/{status}")
    public int requestRes(@PathVariable int status, @RequestBody ReservationDto reservationDto) {
        return  messageService.reserve(status, reservationDto);
    }

    @GetMapping("/getPosts/{email}")
    public Set<GetPostsDto> getPosts(@PathVariable String email) {
        return messageService.getPosts(email);
    }
    @GetMapping("/responseRes/{guideId}")
    public void responseRes(@PathVariable Long guideId) {
        messageService.responseRes(guideId);
    }
}
