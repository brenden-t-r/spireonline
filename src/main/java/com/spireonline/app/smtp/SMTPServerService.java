package com.spireonline.app.smtp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.subethamail.smtp.server.SMTPServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.util.Objects.nonNull;

@Service
public class SMTPServerService
{
    private static final Logger LOG = LoggerFactory.getLogger(SMTPServerService.class);

    @Value("${smtpserver.enabled}")
    String enabled="";
    @Value("${smtpserver.hostName}")
    String hostName="";
    @Value("${smtpserver.domain}")
    String domain="";
    @Value("${smtpserver.port}")
    String port="";

    private final SpireMailReciever spireMailReciever;
    private SMTPServer smtpServer;

    @Autowired
    public SMTPServerService(SpireMailReciever spireMailReciever)
    {
        this.spireMailReciever = spireMailReciever;
    }

    @PostConstruct
    public void start()
    {
        if ("true".equalsIgnoreCase(enabled))
        {
            LOG.info("smtp server enabled...");
            this.smtpServer = new SMTPServer(spireMailReciever);

            if (nonNull(port)) smtpServer.setPort(Integer.parseInt(port));
            if (nonNull(hostName)) smtpServer.setHostName(hostName);
            smtpServer.start();

            LOG.info("** starting smtp server at {}:{}", hostName, port);
        }
    }

    @PreDestroy
    public void stop()
    {
        if ("true".equalsIgnoreCase(enabled))
        {
            LOG.info("stopping smtp server on {}:{} ...bye!", hostName, port);
            this.smtpServer.stop();
        }
    }

    public Boolean isRunning()
    {
        return this.smtpServer.isRunning();
    }


}
