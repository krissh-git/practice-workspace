package com.krishna.msmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender emailSender;


    @Override
    public void sendSimpleMessage(UserDto userDto) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(userDto.getUsername());
        simpleMailMessage.setSubject("Test Subject");
        simpleMailMessage.setText("Hi");

        emailSender.send(simpleMailMessage);

    }
}
