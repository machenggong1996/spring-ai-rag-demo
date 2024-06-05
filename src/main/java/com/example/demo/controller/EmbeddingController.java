package com.example.demo.controller;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author machenggong
 * @since 2024/5/24
 */
@RequestMapping("/embedding")
@RestController
public class EmbeddingController {

    @Autowired
    private EmbeddingClient embeddingClient;

    @GetMapping("/ai/embedding")
    public Map embed(@RequestParam String message1, @RequestParam String message2) {
        EmbeddingResponse embeddingResponse = this.embeddingClient.embedForResponse(List.of(message1, message2));
        return Map.of("embedding", embeddingResponse);
    }

}
