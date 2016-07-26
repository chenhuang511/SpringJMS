package vn.tecapro.example.springjms.service;

import org.springframework.stereotype.Service;
import vn.tecapro.example.springjms.model.Product;

/**
 * Created by HoangTD on 7/26/2016.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public void processOrder(Product product) {

    }
}
