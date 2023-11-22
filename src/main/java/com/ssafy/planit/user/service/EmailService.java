package com.ssafy.planit.user.service;

import com.ssafy.planit.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    private final RedisUtil redisUtil;

    private String authNum;

    public EmailService(JavaMailSender emailSender, RedisUtil redisUtil) {
        this.emailSender = emailSender;
        this.redisUtil = redisUtil;
    }

    public void createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for(int i=0; i<8; i++) {
            int idx = random.nextInt(3);

            switch (idx) {
                case 0 :
                    key.append((char) ((int)random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) ((int)random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        authNum = key.toString();
    }

    public MimeMessage createEmailForm(String email) throws MessagingException, UnsupportedEncodingException {
        createCode();
        String setFrom = "test@gmail.com";
        String toEmail = email;
        String title = "PLANIT 인증번호";

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject(title);

        String msgOfEmail="";
        msgOfEmail += "<div style='margin:20px;'>";
        msgOfEmail += "<h1> 안녕하세요 PLANIT 입니다. </h1>";
        msgOfEmail += "<br>";
        msgOfEmail += "<p>아래 코드를 입력해주세요<p>";
        msgOfEmail += "<br>";
        msgOfEmail += "<p>감사합니다.<p>";
        msgOfEmail += "<br>";
        msgOfEmail += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgOfEmail += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgOfEmail += "<div style='font-size:130%'>";
        msgOfEmail += "CODE : <strong>";
        msgOfEmail += authNum + "</strong><div><br/> ";
        msgOfEmail += "</div>";

        message.setFrom(setFrom);
        message.setText(msgOfEmail, "utf-8", "html");

        return message;
    }

    public String sendEmail(String email) throws MessagingException, UnsupportedEncodingException {

        MimeMessage emailForm = createEmailForm(email);
        try{
            redisUtil.setDataExpire(authNum,email,60*5L);

            try {
                //실제 메일 전송
                emailSender.send(emailForm);
            }catch (Exception e){
                System.out.println("Email Sender error");

            }
        }catch (Exception e){
            System.out.println("Redis error "+ e);
        }


        return authNum;
    }

    public boolean checkAuthNum(String email, String authNum){
        if(redisUtil.getData(authNum)==null){
            return false;
        }
        else return redisUtil.getData(authNum).equals(email);
    }
}