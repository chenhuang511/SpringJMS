package vn.tecapro.example.springjms.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by hoangtd on 7/28/2016.
 */
@Configuration
@ComponentScan(basePackages = {"vn.tecapro.example.springjms"})
@Import({MessageConfiguration.class})
public class AppConfig {
}
