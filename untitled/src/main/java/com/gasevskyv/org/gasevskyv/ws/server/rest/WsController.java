package com.gasevskyv.org.gasevskyv.ws.server.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class WsController {

    private final SimpMessagingTemplate template;
    @Value("${ws.topic}")
    private String wsTopic;


    @PostMapping("/send/ws")
    public ResponseEntity<Void> sendWsMsg(@RequestBody @NonNull Map<String, Object> data) {
        template.convertAndSend(wsTopic, data);
        return ResponseEntity.ok().build();
    }

}
