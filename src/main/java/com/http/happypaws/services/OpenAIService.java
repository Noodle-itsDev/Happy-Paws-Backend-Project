package com.http.happypaws.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

    @Value("${API_OPEN_AI}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getCompletion(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        // Configura el cuerpo de la solicitud
        String requestBody = String.format(
            "{\"model\":\"gpt-3.5-turbo\",\"prompt\":\"%s\",\"max_tokens\":150}",
            prompt
        );

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to get response from OpenAI API, status code: " + response.getStatusCode() + ", body: " + response.getBody());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during API call: " + e.getMessage(), e);
        }
    }
}
