package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("/send")
    public List<Seat> websocket(Principal principal) throws Exception {
        Thread.sleep(1000); // simulated delay
        Random random = new Random();
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(random.nextInt(10) + 1, 1));
        messagingTemplate.convertAndSend("/topic/greetings",seats);
        return null;
    }

}
