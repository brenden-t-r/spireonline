package com.spireonline.app;

import com.spireonline.app.config.RootConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.subethamail.smtp.client.SmartClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@Import(RootConfig.class)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Profile("development")
	@Bean
	public void emailtest()
	{
		try
		{
			final SmartClient client = new SmartClient("localhost", 2525, "localhost");
			client.from("nick@bb.com");
			client.to("rahul@bb.com");
			final byte[] bytes = Files.readAllBytes(Paths.get(new ClassPathResource("sound/killer_whale_2.mp3").getURI()));
			client.dataStart();
			client.dataWrite(bytes, bytes.length-1);
			client.dataEnd();
			client.quit();

//			final Properties properties = System.getProperties();
//			properties.setProperty("mail.smtp.host", "localhost");
//			properties.setProperty("mail.smtp.port", "2525");
//			final Session session = Session.getInstance(properties);
//
//			final MimeMessage baseMsg = new MimeMessage(session);
//
//			final MimeBodyPart bp1 = new MimeBodyPart();
//			bp1.setHeader("Content-Type", "text/plain");
//			bp1.setContent("Hello World!!!", "text/plain; charset=\"ISO-8859-1\"");
//
//			final MimeBodyPart attchFile = new MimeBodyPart();
//			final FileDataSource fileAttchment = new FileDataSource(ResourceUtils.getFile("sound/killer_whale_2.mp3"));
//			final DataHandler dataHandler = new DataHandler(fileAttchment);
//			attchFile.setDataHandler(dataHandler);
//			attchFile.setFileName(fileAttchment.getName());
//
//			final Multipart multipart  = new MimeMultipart();
//			multipart.addBodyPart(bp1);
//			multipart.addBodyPart(attchFile);
//
//			baseMsg.setFrom(new InternetAddress("Ted <ted@home.com>"));
//			baseMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(
//					"success@subethamail.org"));
//			baseMsg.setSubject("Test Big attached file message");
//			baseMsg.setContent(multipart);
//			baseMsg.saveChanges();
//
//			System.out.println("Send started");
//			Transport t = new SMTPTransport(session, new URLName("smtp://localhost:"+2525));
//			long started = System.currentTimeMillis();
//			t.connect();
//			t.sendMessage(baseMsg, new Address[] {new InternetAddress(
//					"success@subethamail.org")});
//			t.close();
//			started = System.currentTimeMillis() - started;
//			System.out.println("elapsed: "+ started);

		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
