package vn.tecapro.example.springjms.configuration;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import vn.tecapro.example.springjms.messaging.MessageReceiver;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Configuration
@ComponentScan({"vn.tecapro.example.springjms"})
public class MessageConfiguration {
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    private static final String ORDER_QUEUE = "order-queue";

    private static final String ORDER_RESPONSE_QUEUE = "order-respone-queue";

    @Autowired
    MessageReceiver messageReceiver;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("vn.tecapro.example.springjms"));
        return connectionFactory;
    }

    //Optional
    @Bean
    public ConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setTargetConnectionFactory(connectionFactory());
        connectionFactory.setSessionCacheSize(10);
        return connectionFactory;
    }

    //Message listener container for calling messageReceiver.onMessage on message reception
    @Bean
    public MessageListenerContainer getContainer() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName(ORDER_QUEUE);
        container.setMessageListener(messageReceiver);
        return container;
    }

    //for sending messages
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_RESPONSE_QUEUE);
        return template;
    }

    @Bean
    public MessageConverter convert() {
        return new SimpleMessageConverter();
    }
}
