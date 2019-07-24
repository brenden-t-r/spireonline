package com.spireonline.app.smtp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.subethamail.smtp.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class SpireMailReciever implements MessageHandlerFactory
{
    private static final Logger LOG = LoggerFactory.getLogger(SpireMailReciever.class);

    @Override
    public MessageHandler create(MessageContext ctx)
    {
        return new Handler(ctx);
    }

    class Handler implements MessageHandler
    {
        private final Logger LOG = LoggerFactory.getLogger(Handler.class);
        MessageContext ctx;

        public Handler(MessageContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void from(String from) throws RejectException
        {
            LOG.info("FROM: {}", from);
        }

        @Override
        public void recipient(String recipient) throws RejectException
        {
            LOG.info("REIPIENT: {}", recipient );
        }

        @Override
        public void data(InputStream data) throws RejectException, TooMuchDataException, IOException
        {
            LOG.info("MAIL DATA");
            LOG.info("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            LOG.info("available bytes: {}", data.available());
            LOG.info("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        }

        @Override
        public void done()
        {
            LOG.info("Finished");
        }


    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
