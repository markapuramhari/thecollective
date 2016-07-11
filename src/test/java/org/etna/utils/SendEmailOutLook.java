package org.etna.utils;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.etna.maincontroller.MainController;
import org.etna.utils.PropertyFileReader;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/*
 * @author Hemanth.Sridhar
 */

public class SendEmailOutLook extends MainController {
	
	
    public static void sendemail(int pass, int fail, int skip, File zipFile) throws Exception {
    
        // Recipient's email ID needs to be mentioned.
    	String to[] = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "to").split(",");//change accordingly
        String cc[] = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "cc").split(",");
        String bcc[] = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "bcc").split(",");
        
        // Sender's email ID needs to be mentioned
        String from = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "from");//change accordingly
        final String username = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "username");//change accordingly
        final String password = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "password");//change accordingly


        String host = "smtp.office365.com";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            MimeBodyPart messageBodyPart =
                    new MimeBodyPart();

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            for(int i=0;i<to.length;i++){
                message.addRecipient(Message.RecipientType.TO, new
                InternetAddress(to[i]));
                }
            
            for(int i=0;i<cc.length;i++){
                message.addRecipient(Message.RecipientType.CC, new
                InternetAddress(cc[i]));
                }

                for(int i=0;i<bcc.length;i++){
                message.addRecipient(Message.RecipientType.BCC, new
                InternetAddress(bcc[i]));
                }
            // Set Subject: header field
            message.setSubject(PropertyFileReader.propertiesReader(MainController.applicationSetUp, "productName")+" "+"Automation Report"+" "+getDate());
            String messagtosend = "Hi,"
                    +"<br><br>PFB the Automation Execution Report Summary."
                    +"<br><br><b><u>Execution Summary</u></b>"
                    +"<br>&nbsp;&nbsp;Product :"+" "+PropertyFileReader.propertiesReader(MainController.applicationSetUp, "productName")
                    +"<br>&nbsp;&nbsp;Operating System:"+ System.getProperty("os.name")
                    +"<br><br><b><u>Report Summary</u></b>"
                    +"<br>&nbsp;&nbsp;Total number of TC executed:"+ (pass + fail + skip)
                    +"<br>&nbsp;&nbsp;Passed:"+pass
                    +"<br>&nbsp;&nbsp;Failed:" + fail
                    +"<br>&nbsp;&nbsp;Skipped:" + skip
                    +"<br>&nbsp;&nbsp;Execution Ended at:" + getTime()
                    +"<br><br><b>**Note</b>:PFA for Detailed Report."
                    +"<br><br>Regards,"
                    +"<br><br>Hemanth B S";
            // Now set the actual message
            messageBodyPart.setContent(messagtosend, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            String filename = zipFile.getAbsolutePath();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            filename = zipFile.getName();//filename.substring((filename.lastIndexOf("/")) + 1);
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            // Send message
            Transport.send(message);

            //System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    //time for email if needed
    public static String getTime()
    {
    	DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
    	Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
    
    
    //to get date if needed
    public static String getDate()
    {
    	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    	Date date = new Date();
    	String DateForReport = dateFormat.format(date);
    	return DateForReport;
    }
}
