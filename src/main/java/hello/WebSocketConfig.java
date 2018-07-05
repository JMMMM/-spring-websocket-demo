package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    //这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息。
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息（比较绕，看完整个例子，大概就能明白了）
        config.enableSimpleBroker("/topic");
        //指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    //这个方法的作用是添加一个服务端点，来接收客户端的连接。
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //表示添加了一个/gs-guide-websocket节点，客户端就可以通过这个端点来进行连接。
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}