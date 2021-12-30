package com.mdsap.wlf.mail;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.mdsap.wlf.db.domain.MEMatchResult;
import com.mdsap.wlf.db.domain.Wlmwltype;
import com.mdsap.wlf.db.domain.model.MailResult;
import com.mdsap.wlf.db.repository.WlmwltypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
/*
 * White space is preserved in text email with \n. It is also preserved in HTML
 * email with the css in the html template
 */
public class SendEmailServiceSpringBootImpl implements SendEmailService {


    @Autowired
    private WlmwltypeRepository repoWlmwltype;

    private List<MailResult> mailResultList;

    // JavaMailSenderImpl is thread safe after it's constructed
    @Autowired
    private JavaMailSender mailSender;

    // needed for HTML email templating
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${cherryshoe.mail.defaultFrom}")
    private String defaultFrom;
    @Value("${cherryshoe.mail.defaultTo}")
    private String defaultTo;

    // The default configuration of Thymeleaf expects that all HTML files are
    // placed under resources/templates directory and ends with the .html
    // extension.
    // Can also externalize the templates/*.html files
    @Value("${cherryshoe.mail.defaultMailTemplate}")
    private String defaultMailTemplate;

    private Logger log = LoggerFactory.getLogger(getClass());

    private final ThreadLocal<DateFormat> threadLocalDf = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MM/dd/yyyy");
        }
    };

    @Override
    public void sendHtmlEmail() throws IOException {
        MimeMessage mail = mailSender.createMimeMessage();
        InputStream imageIs = null;

       // mailResultList = new ArrayList<MailResult>();


        try {

            // set multiple context variables key/value pairs for email template
            String templateMailBodyNameKey = "name";
            String templateMailBodyNameVal = "[Name]";
            String templateMailBodyTable1Key = "table1";
            StringBuffer templateMailBodyTable1Val = new StringBuffer();
            String templateMailBodyImageKey = "imageResourceName";
            String templateMailBodyImageVal = "pttlogo.png";

            mailResultList.sort(Comparator.comparing(MailResult::getKeyWord));
            // table 1 get data
            for (MailResult result:mailResultList)
           {
               templateMailBodyTable1Val.append("<tr><td class=\"twenty-five\">");
               templateMailBodyTable1Val.append(result.getKeyWord());
               templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getMatchScore());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getMatchDate());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getBlakListUid());
                templateMailBodyTable1Val.append("</td>");

               templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
               templateMailBodyTable1Val.append(result.getBlakListType());
               templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getBlakListName());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getBlakListCountry());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getBlakListTINNumber());
                templateMailBodyTable1Val.append("</td>");



                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getTransactionId());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getTxnchanneltype());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getTxnprodname());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getTxnsysid());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getScfullname());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getScnationality());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getScnationalid());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getRcfullname());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getRcnationality());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("<td class=\"twenty-five\">");
                templateMailBodyTable1Val.append(result.getRcnationalid());
                templateMailBodyTable1Val.append("</td>");

                templateMailBodyTable1Val.append("</tr>");

            }

            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put(templateMailBodyNameKey, templateMailBodyNameVal);
            variables.put(templateMailBodyTable1Key, templateMailBodyTable1Val.toString());
            variables.put(templateMailBodyImageKey, templateMailBodyImageVal);

            Context context = new Context();
            variables.forEach((name, value) -> context.setVariable(name, value));

            String content = templateEngine.process(defaultMailTemplate, context);

            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(defaultTo);
            helper.setReplyTo(defaultFrom);
            helper.setFrom(defaultFrom);
            helper.setSubject("PTT Kara Liste Uygulaması - " + threadLocalDf.get().format(new Date()));
            helper.setText(content, true); // make html email

            // Add the inline image, must go after setText. Referenced from the
            // mail template as "cid:${imageResourceName}"
           // imageIs = this.getClass().getClassLoader().getResourceAsStream("../../../../resources/"+ templateMailBodyImageVal);
          // byte[] imageByteArray = IOUtils.toByteArray(imageIs);

         //   final InputStreamSource imageSource = new ByteArrayResource(imageByteArray);
          //  helper.addInline(templateMailBodyImageVal, imageSource, "image/png");

            mailSender.send(mail);
        } catch (MessagingException e) {
            log.warn(e.getMessage());
        } finally {
           // if (imageIs != null)
            //    imageIs.close();
        }

    }

    public List<MailResult> getMailResultList() {
        return mailResultList;
    }

    public void setMailResultList(List<MailResult> mailResultList, List<MEMatchResult> meMatchResult) {

        this.mailResultList = new ArrayList<MailResult>();


        int i=0;
         for(MailResult result:mailResultList)
        {
         Optional<Wlmwltype> ty=  repoWlmwltype.findById(Integer.parseInt( result.getBlakListType()));
         result.setBlakListType(ty.get().getName());


            result.setBlakListUid(meMatchResult.get(i).getId());

         this.mailResultList.add(result);
         i++;
        }
        this.mailResultList = mailResultList;

    }
}