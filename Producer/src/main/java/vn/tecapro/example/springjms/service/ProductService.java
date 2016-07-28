package vn.tecapro.example.springjms.service;

import vn.tecapro.example.springjms.model.Product;

/**
 * Created by hoangtd on 7/28/2016.
 */
public interface ProductService {
    public void sendProduct(Product product);
}
