package websockettest.websockettest.websocket;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;
import org.springframework.web.util.HtmlUtils;
import websockettest.websockettest.entities.Greeting;
import websockettest.websockettest.entities.HelloMessage;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        // Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.name()) + "!");
    }

}