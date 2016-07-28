package vn.tecapro.example.springjms.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import vn.tecapro.example.springjms.model.InventoryResponse;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Component
public class MessageReceiver implements MessageListener {

    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @Autowired
    MessageConverter messageConverter;

    @Override
    public void onMessage(Message message) {
        try {
            LOG.info("++++++++++++++++++++++++++++++++++++++++++");
            InventoryResponse response = (InventoryResponse) messageConverter.fromMessage(message);
            LOG.info("Application: order response received: {}", response);
            LOG.info("++++++++++++++++++++++++++++++++++++++++++");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
