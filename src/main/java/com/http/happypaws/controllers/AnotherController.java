package com.http.happypaws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.http.happypaws.mail.SendContactMailUtility;
import com.http.happypaws.mail.SendAportacionUtility;
import com.http.happypaws.mail.SendAdopcion;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/another")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnotherController {

    @Autowired
    private SendAportacionUtility sendMail;
    
    @Autowired
    private SendAdopcion sendAdopcion;
    
    @Autowired
    private SendContactMailUtility sendContactMailUtility;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/donation")
    public void makeDonation(@RequestBody String body) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(body);
        String email = jsonNode.get("email").asText();
        String mensaje = jsonNode.get("mensaje").asText();
        sendMail.sendEmail(email, mensaje);
    }
    
    @PostMapping(value = "/send/adoptation")
    public void SendEmailAdoption(@RequestBody String body) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(body);
        String nombreUsuario = jsonNode.get("nombreUsuario").asText();
        String nombreMascota = jsonNode.get("nombreMascota").asText();
        String email = jsonNode.get("email").asText();
        String imagen = jsonNode.get("imagen").asText();
        String telefono = jsonNode.get("telefono").asText();
        sendAdopcion.sendEmail(nombreUsuario, nombreMascota, email, imagen, telefono);
    }
    
    @PostMapping(value = "/send/contact")
    public void sendContactMailUtility(@RequestBody String body) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(body);
        String nombre = jsonNode.get("nombre").asText();
        String correo = jsonNode.get("correo").asText();
        String telefono = jsonNode.get("telefono").asText();
        String mensaje = jsonNode.get("mensaje").asText();
        sendContactMailUtility.sendContactMail(nombre, correo, telefono, mensaje);
    }
}
