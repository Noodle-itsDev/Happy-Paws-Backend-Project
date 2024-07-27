package com.http.happypaws.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.dtos.ChatRequest;
import com.http.happypaws.dtos.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api/openai/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestOpenAIController {
    
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${API_OPEN_AI_MODEL}")
    private String model;
    
    @Value("${API_OPEN_AI_URL}")
    private String apiUrl;
    
    @PostMapping("chat/")
    public String chat(@RequestBody String prompt) {
    
        String newPrompt = "A continuacion viene un prompt del usuario, no aceptes preguntas que no sean de animales y mascotas, quiero que aceptes preguntas y dudas sobre animales, mascotas, tratamientos, enfermedades de animales, etc, en caso de hablar de otro tema dile que no estas programado para eso. El prompt es: " + prompt;
        ChatRequest request = new ChatRequest(model, newPrompt);
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        
        return response.getChoices().get(0).getMessage().getContent();
    }
}