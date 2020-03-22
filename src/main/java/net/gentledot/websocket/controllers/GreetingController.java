package net.gentledot.websocket.controllers;

import net.gentledot.websocket.models.messages.Greeting;
import net.gentledot.websocket.models.messages.HelloMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        String htmlStr = HtmlUtils.htmlEscape(message.getName());

        log.debug("생성된 HTML 문자열 : {}", htmlStr);
        return new Greeting("Hello, " + htmlStr + "!");
    }
}
