package com.cook4me.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Paweł Proc on 2016-12-06.
 */
@ConfigurationProperties
@ComponentScan(basePackages = "com/cook4me/controller")
public class ApplicationConfiguration {

}
