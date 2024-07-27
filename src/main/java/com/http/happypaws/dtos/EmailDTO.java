package com.http.happypaws.dtos;

public class EmailDTO {

    private String to;
    private String subject;
    private String text;

    public EmailDTO(){}
    
    public EmailDTO(String to, String subject, String text){
      this.to = to;
      this.subject =subject;
      this.text = text;
    }
    
    public String getTo(){
      return to;
    }
    
    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }
}