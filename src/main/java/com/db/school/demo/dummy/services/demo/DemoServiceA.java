package com.db.school.demo.dummy.services.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("dev")
public class DemoServiceA implements DemoService {
    Logger logger = LoggerFactory.getLogger(DemoServiceA.class);

    @Override
    public String displayDemoMessage() {
        String message = "DemoServiceA display message.";
        logger.info(message);
        return message;
    }
}
