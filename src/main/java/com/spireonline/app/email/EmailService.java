package com.spireonline.app.email;

import com.spireonline.app.service.SpireProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.util.Objects.nonNull;

@Service
public class EmailService
{
    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
    private static final int BUFFER_SIZE = 4096;

    @Value("${smtpserver.enabled}")
    String enabled="";
    @Value("${email.username}")
    String username="";
    @Value("${email.password}")
    String password="";

    private SpireProjectService spireProjectService;

    @Autowired
    public EmailService(SpireProjectService spireProjectService)
    {
        this.spireProjectService = spireProjectService;
    }

    @Scheduled(cron="*/10 * * * *")
    @Async
    public void start()
    {
        if ("true".equalsIgnoreCase(enabled))
        {
            LOG.info("email server enabled... running push");


            final Session sesson = Session.getDefaultInstance(new Properties());
            final ArrayList<File> files = new ArrayList<>();
            try
            {
                final Store imaps = sesson.getStore("imaps");
                imaps.connect("imap.googlemail.com", 993, username, password);
                final Folder inbox = imaps.getFolder("INBOX");
                inbox.open(Folder.READ_WRITE); // so we can mark it read​
                final Message[] msgs = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
                if (nonNull(msgs)) LOG.info("Unread messages in inbox... {}", msgs.length);

                for (Message message : msgs)
                {
                    final Multipart mul = (Multipart) message.getContent(); // This should mark mail as opened

                    for (int bpi = 0; bpi < mul.getCount(); bpi++)
                    {
                        final BodyPart bodyPart = mul.getBodyPart(bpi);
                        if (!Part.ATTACHMENT.equals(bodyPart.getDisposition()) &&
                                StringUtils.isEmpty(bodyPart.getFileName()))
                            continue;final String ext = bodyPart.getFileName().substring(bodyPart.getFileName().lastIndexOf("."));


                        if (!".spire".equalsIgnoreCase(ext))
                        {
                            LOG.error("Attachment not a spire archive... {}", bodyPart.getFileName());
                            continue;
                        }

                        final InputStream is = bodyPart.getInputStream();

                        unzipSpireArchiveAndSave(is);

                    }

                }
            } catch (MessagingException | IOException e)
            {
                LOG.error(e.getMessage());
            }


        }
    }

    private void unzipSpireArchiveAndSave(InputStream is)
    {
        final ZipInputStream zipInputStream = new ZipInputStream(is);

        try
        {
            final ZipEntry entry = zipInputStream.getNextEntry();
            while (nonNull(entry))
            {
                if (!entry.isDirectory())
                {
                    extractFile(zipInputStream, entry.getName());
                }
            }

            zipInputStream.close();
        } catch (IOException e)
        {
            LOG.error("unzipping error.. {}", e.getMessage());
        }
    }

    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String fileName) throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1)
        {
            bos.write(bytesIn, 0, read);
        }
        bos.close();

    }

}
