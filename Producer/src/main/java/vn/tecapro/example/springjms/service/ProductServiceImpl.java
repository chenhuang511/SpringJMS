package vn.tecapro.example.springjms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tecapro.example.springjms.messaging.MessageSender;
import vn.tecapro.example.springjms.model.Product;

/**
 * Created by hoangtd on 7/28/2016.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void sendProduct(Product product) {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        LOG.info("Application : sending order request {}", product);
        messageSender.sendMessage(product);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
