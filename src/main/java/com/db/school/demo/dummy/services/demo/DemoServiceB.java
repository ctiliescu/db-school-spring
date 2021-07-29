package com.db.school.demo.dummy.services.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceB implements DemoService {
    Logger logger = LoggerFactory.getLogger(DemoServiceB.class);

    @Override
    public String displayDemoMessage() {
        String message = "DemoServiceB display message from B.";
        logger.info(message);
        return message;
    }
}
