package vn.tecapro.example.springjms.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

}
