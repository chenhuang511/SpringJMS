package vn.tecapro.example.springjms.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import vn.tecapro.example.springjms.model.InventoryResponse;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final InventoryResponse response) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(response);
                return objectMessage;
            }
        });
    }
}