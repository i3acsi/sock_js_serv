package com.gasevskyv.org.gasevskyv.ws.server.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class WsController {

    private final SimpMessagingTemplate template;
    private static final String TOPIC_WS = "/topic/1";


    @PostMapping("/send/ws")
    public ResponseEntity<Void> sendWsMsg(@RequestBody @NonNull Map<String, Object> data) {
        template.convertAndSend(TOPIC_WS, data);
        return ResponseEntity.ok().build();
    }

}
