package com.technokratos.util;

import com.technokratos.exception.EmailNotSendException;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Component
@Slf4j
public class EmailUtil {

    @Autowired
    private final JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to, String subject, String templateName, Map<String, Object> data) {

        try {
            String mailTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freeMarkerConfiguration.getConfiguration().getTemplate(templateName + ".ftl"),
                    data);

            MimeMessagePreparator preparator = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setSubject(subject);
                messageHelper.setText(mailTemplate, true);
                messageHelper.setTo(to);
                messageHelper.setFrom(from);
            };
            mailSender.send(preparator);
        } catch (IOException | TemplateException | MailException e) {
            System.out.println(e);
            throw new EmailNotSendException();
        }
    }
}
