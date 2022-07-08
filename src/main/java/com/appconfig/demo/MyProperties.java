package com.appconfig.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myfeature")
@Data
public class MyProperties {

    private boolean enabled;
    private int threshold;
    private int commonProp;

}