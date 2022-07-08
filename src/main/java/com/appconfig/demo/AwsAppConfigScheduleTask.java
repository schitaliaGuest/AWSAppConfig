package com.appconfig.demo;

import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AwsAppConfigScheduleTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsAppConfigScheduleTask.class);

    @Autowired
    private MyProperties myproperties;

    @Autowired
    private AwsAppConfig appConfiguration;

    @Scheduled(fixedRate = 5000)
    public void pollConfiguration() throws UnsupportedEncodingException {
        LOGGER.info("polls configuration from aws app config");
        JSONObject externalizedConfig = appConfiguration.getConfiguration();


        boolean enabledValue = externalizedConfig.getBoolean("enabled");
        String enabledValueMessage = String.format("myfeature enabled : %s", String.valueOf(enabledValue));

        LOGGER.info(enabledValueMessage);

        int thresholdValue = externalizedConfig.getInt("threshold");
        String thresholdValueMessage = String.format("myfeature threshold : %s", String.valueOf(thresholdValue));

        LOGGER.info(thresholdValueMessage);

        myproperties.setEnabled(enabledValue);
        myproperties.setThreshold(thresholdValue);
    }

}