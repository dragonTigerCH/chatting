package com.socket.chatting.member.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberController {

    @MessageMapping()
    public String chatGET(String data){

        log.info("@MemberController, chat GET()");
        log.info("data = {}",data);

        return data;
    }
}
