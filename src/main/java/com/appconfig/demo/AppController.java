package com.appconfig.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feature")
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private MyProperties myProperties;

    @GetMapping("/isEnabled")
    public boolean isEnabled() {
        boolean isEnabled = myProperties.isEnabled();
        String message = "Feature is " + (isEnabled ? "enabled" : "disabled");
        LOGGER.info(message);
        return isEnabled;
    }

    @GetMapping("/threshold")
    public int getLimit() {
        int threshold = myProperties.getThreshold();
        String message = "Feature thresold is " + threshold;
        LOGGER.info(message);
        return threshold;
    }

    @GetMapping("/commonProp")
    public int getCommonProp() {
        int commonProp = myProperties.getCommonProp();
        String message = "Common Prop is " + commonProp;
        LOGGER.info(message);
        return commonProp;
    }
}
