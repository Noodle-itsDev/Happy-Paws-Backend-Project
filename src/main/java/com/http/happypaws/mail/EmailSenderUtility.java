package com.http.happypaws.mail;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtility {

    @Value("${MAILJET_API_KEY_PUBLIC}")
    private String apiKeyPublic;

    @Value("${MAILJET_API_KEY_PRIVATE}")
    private String apiKeyPrivate;

    @Value("${MAILJET_ORIGIN}")
    private String apiOrigin;

    @Value("${MAILJET_ORIGIN_NAME}")
    private String apiOriginName;

    @Value("${MAILJET_SUBJECT}")
    private String apiSubject;
    
    @Value("${SERVER_ADDRESS}")
    private String srvAddress;

    public void sendEmail(String recipientEmail, String recipientName, Long usuarioId) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client = new MailjetClient(apiKeyPublic, apiKeyPrivate, new ClientOptions("v3.1"));

        String header = "https://res.cloudinary.com/dg8lfyj4a/image/upload/v1722071924/ckwrcoka6dhscqncgz5u.png";
        String logo = "https://res.cloudinary.com/dg8lfyj4a/image/upload/v1722073333/tl5nm1jqhex3tn2uqmni.png";
        String footer = "https://res.cloudinary.com/dg8lfyj4a/image/upload/v1722073213/g3l80kgjyr8id7lctjtg.png";

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
            .property(Emailv31.MESSAGES, new JSONArray()
                .put(new JSONObject()
                    .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", apiOrigin)
                        .put("Name", apiOriginName))
                    .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                            .put("Email", recipientEmail)
                            .put("Name", recipientName)))
                    .put(Emailv31.Message.SUBJECT, apiSubject)
                    .put(Emailv31.Message.TEXTPART, "")
                    .put(Emailv31.Message.HTMLPART, "<html><body><div style=''><div><img src='" + header + "' alt='Happy Paws Logo' style='width: 100%; height: 5rem; position:fixed; top: 0;' /></div><div style='text-align: center;'><img src='" + logo + "' style='width: 250px;' /></div><div style='margin: 2rem 20%;'><p style='font-size: large; text-align: center; font-family: system-ui;'>Bienvenido a <span style='color: green;'><b>Happy Paws</b></span> "+ recipientName +", plataforma de <b>adopci&oacute;n de mascotas y gesti&oacute;n de protectoras</b>. Nuestro objetivo principal es colaborar con entidades sin &aacute;nimo de lucro en su gesti&oacute;n diaria.</p><p  style='font-size: large; text-align: center; font-family: system-ui;'>Antes de continuar, <b>activa tu cuenta</b> pulsando en el siguiente bot&oacute;n.</p></div><div style='text-align: center; margin-bottom: 2rem;'><a href='" + srvAddress +"/api/user/validate/"+ usuarioId  +"' style='background-color: green; padding: 0.8rem 1.5rem; color: white; text-transform: uppercase; border-radius: 12px;'>Activar</a></div></div><img src='" + footer + "' style='position:fixed; bottom: 0; height: 5rem; width: 100%;'/></body></html>")
                    .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest"))
            );

        MailjetResponse response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}











