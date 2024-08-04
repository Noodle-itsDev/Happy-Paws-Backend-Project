package com.http.happypaws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.http.happypaws.mail.SendAportacionUtility;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/another")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnotherController {

    @Autowired
    private SendAportacionUtility sendMail;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/donation")
    public void makeDonation(@RequestBody String body) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(body);
        String email = jsonNode.get("email").asText();
        String mensaje = jsonNode.get("mensaje").asText();
        sendMail.sendEmail(email, mensaje);
    }
}
