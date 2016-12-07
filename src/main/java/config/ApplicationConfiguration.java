package config;

import controller.OfferManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Paweł Proc on 2016-12-06.
 */
@ConfigurationProperties
@ComponentScan( basePackages = "controller")
public class ApplicationConfiguration {

}
