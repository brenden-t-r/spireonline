package com.spireonline.app;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.*;
import java.util.Properties;

@Service
public class EmailService {

    public EmailService() throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("ail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth=true", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, null);

        Store store = session.getStore("imaps");
        store.connect("smtp.gmail.com", "sendtospireonline@gmail.com","Spire666!");

        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_ONLY);
        int messageCount = inbox.getMessageCount();
        System.out.println(messageCount + " Emails!");

        Message[] messages = inbox.getMessages();
        Message message = messages[0];
        System.out.println("------------------------------");

        String contentType = messages[0].getContentType();

        System.out.println(contentType);

        //if (contentType.contains("multipart")) {
            // this message may contain attachment
            Multipart multiPart = (Multipart) message.getContent();

            for (int i = 0; i < multiPart.getCount(); i++) {
                MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
                //if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                    // this part is attachment
                    // code to save attachment...
                    String destFilePath = "C:/Users/Owner/Desktop/" + part.getFileName();
                    FileOutputStream output = new FileOutputStream(destFilePath);
                    InputStream input = part.getInputStream();

                    byte[] buffer = new byte[4096];

                    int byteRead;

                    while ((byteRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, byteRead);
                    }
                    output.close();
                //}
            }
        //}
    }


}
