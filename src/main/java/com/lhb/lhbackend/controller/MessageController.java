package com.lhb.lhbackend.controller;

import com.lhb.lhbackend.dto.MessageDto;
import com.lhb.lhbackend.entity.Message;
import com.lhb.lhbackend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto);
    }
}
