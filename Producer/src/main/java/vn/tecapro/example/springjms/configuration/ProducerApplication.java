package vn.tecapro.example.springjms.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import vn.tecapro.example.springjms.model.Product;
import vn.tecapro.example.springjms.service.ProductService;
import vn.tecapro.example.springjms.util.BasicUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hoangtd on 7/28/2016.
 */
public class ProducerApplication {

    static final Logger LOG = LoggerFactory.getLogger(ProducerApplication.class);

    private static AtomicInteger id = new AtomicInteger();

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = (ProductService) context.getBean("productService");

        Product product = getProduct();
        LOG.info("Product Application: sending order {}", product);
        productService.sendProduct(product);

        try {
            Thread.sleep(60000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        context.close();
    }

    private static Product getProduct() {
        Product p = new Product();
        p.setName("Product " + id.incrementAndGet());
        p.setProductId(BasicUtil.getUniqueId());
        return p;
    }
}
