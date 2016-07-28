package vn.tecapro.example.springjms.service;

import vn.tecapro.example.springjms.model.Product;

/**
 * Created by HoangTD on 7/26/2016.
 */
public interface OrderService {
    public void processOrder(Product product);
}
