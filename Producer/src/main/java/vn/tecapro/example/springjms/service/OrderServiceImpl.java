package vn.tecapro.example.springjms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tecapro.example.springjms.messaging.MessageSender;
import vn.tecapro.example.springjms.model.InventoryResponse;
import vn.tecapro.example.springjms.model.Product;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void processOrder(Product product) {
        InventoryResponse response = prepareResponse(product);
        LOG.info("Inventory : sending order confirmation {}", response);
    }

    private InventoryResponse prepareResponse(Product product) {
        InventoryResponse response = new InventoryResponse();
        response.setProductId(product.getProductId());
        response.setReturnCode(200);
        response.setComment("Order processed successfully");
        return response;
    }
}
