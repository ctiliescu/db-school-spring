package com.db.school.demo.dummy.services.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DemoServiceA implements DemoService {
    Logger logger = LoggerFactory.getLogger(DemoServiceA.class);

    @Override
    public String displayDemoMessage() {
        String message = "DemoServiceA display message.";
        logger.info(message);
        return message;
    }
}
