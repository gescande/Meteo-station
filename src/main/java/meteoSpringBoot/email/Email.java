package meteoSpringBoot.email;


import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Email
{
    private static final Logger logger = Logger.getLogger(Email.class);

    private MailSender mailSender;
    private SimpleMailMessage templateMessage;
    private String name;
    private String address;
    private String message;

    public Email(MailSender mailSender, SimpleMailMessage templateMessage, String name, String address, String message) {
        this.mailSender = mailSender;
        this.templateMessage = templateMessage;
        this.name = name;
        this.address = address;
        this.message = message;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail()
    {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(this.address);
        msg.setSubject("Contact from "+this.name);
        msg.setTo("guillaume_escande@hotmail.fr");
        msg.setText("Message : "+this.message);
        try{
            this.mailSender.send(msg);
        }
        catch (MailException e) {
            logger.error(e);
        }
    }

}
