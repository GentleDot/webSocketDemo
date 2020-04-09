package net.gentledot.websocket.controllers;

import net.gentledot.websocket.models.chat.Content;
import net.gentledot.websocket.models.response.ChatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/chat")
    @SendTo("/gentlechat/chatting")
    public ChatResponse broadcastingMessage(Content message) {
        return message.generateResponse();
    }
}
