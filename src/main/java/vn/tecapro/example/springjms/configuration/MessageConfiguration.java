package vn.tecapro.example.springjms.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Configuration
public class MessageConfiguration {
    private static final String DEFAULT_BROKER_URL = "tcp://10.0.0.19:61616";

    private static final String ORDER_QUEUE = "order-queue";

    private static final String ORDER_RESPONSE_QUEUE = "order-respone-queue";

}
