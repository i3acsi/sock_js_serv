package com.gasevskyv.org.gasevskyv.ws.server.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WsMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Конфигурация брокера сообщений, который будет обрабатывать сообщения, отправляемые через WebSocket.
     *
     * @param config - реестр для настройки параметров брокера
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        ThreadPoolTaskScheduler ts = new ThreadPoolTaskScheduler();
        ts.setPoolSize(5);
        ts.setThreadNamePrefix("ws-heartbeat-thread-");
        ts.initialize();

        config
                .enableSimpleBroker("/topic")
                .setTaskScheduler(ts);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/secured/ws-endpoint")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }


}