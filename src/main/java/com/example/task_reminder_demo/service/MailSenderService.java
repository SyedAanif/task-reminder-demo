package com.example.task_reminder_demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailSenderService {
    // varargs --> variable number of arguments

    private JavaMailSender javaMailSender;

    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String from;

    // Text Block
    String template = """
            Hey %s,
            
            This is a formatted test mail using
                    TEXT------->BLOCK
                    
            Regards,
            %d
            """;


    @PostConstruct
    public void sendSimpleMail() {

        System.out.println("Sending Mail!!!");

        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo("<<set to mail>>");
            simpleMailMessage.setSubject("Simple Test Mail");
//            simpleMailMessage.setText("Hey, This is a test mail. Regards, Session");
//            simpleMailMessage.setText("Hey, \n\nThis is a test mail. \n\nRegards, \nSession");
            simpleMailMessage.setText(String.format(template, "NAME", 12345)); // text block


            javaMailSender.send(simpleMailMessage);
            System.out.println("Mail Sent!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String htmlTemplate = """
            <html>
            <body>
                <h1> Hey %s, </h1>
                <p>Attachment mail number: %d</p>
            </body>
            </html>
            """;

    @PostConstruct
    public void sendAttachmentMail() {

        System.out.println("Sending Attachment Mail!!!");

        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo("<<set to mail>>");
            mimeMessageHelper.setSubject("Attachment Based Mail Test");
            mimeMessageHelper.setText(String.format(htmlTemplate, "naam", 4321), true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File("src/main/java/com/example/task_reminder_demo/service/dummy.jpg"));

            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

            javaMailSender.send(mimeMessage);
            System.out.println("Mail Sent!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
