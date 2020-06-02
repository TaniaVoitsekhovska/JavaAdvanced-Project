package ua.lviv.home.JavaProject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {
    private static final Logger LOG = LoggerFactory.getLogger(EmailSendingService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${appBaseDomain}")
    private String appBaseDomain;
    @Value("${verifyLink}")
    private String verifyLink;

    public void sendVerificationEmail(String userEmail, String hash) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("Please verify your email");

        String text = "Click link below to confirm email and finish registration.\n";
        String link = appBaseDomain + verifyLink + hash;

        simpleMailMessage.setText(text + link);

        try {
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            LOG.error(String.format("Couldn't send email for verification was sent to user by @s.", userEmail));
            e.printStackTrace();
        }
        LOG.info(String.format("Email for verification was sent to user by @s.", userEmail));
    }
}
