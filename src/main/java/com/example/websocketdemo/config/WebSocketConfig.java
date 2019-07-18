package com.example.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        // WebSocket Server 위치 : localhost:8080/ws
        // withSockJS : WebSocket이 지원되지 않는 브라우저에 WebSocket 지원
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        // 메시지를 구독하는 요청의 prefix는 /app
        // localhost:8080/ws/app
        registry.enableSimpleBroker("/topic");
        // 메시지를 발행하는 요청의 prefix는 topic
        // localhost:8080/ws/topic
        
        // Broker구독자 관리가 알아서 된다.
        
        // MessageBroker : "/topic" "/queue"
        // topic : 브로드캐스트, queue : 1대1 채팅
    }
}