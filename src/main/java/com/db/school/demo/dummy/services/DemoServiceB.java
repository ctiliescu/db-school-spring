package com.db.school.demo.dummy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceB implements DemoService {
    Logger logger = LoggerFactory.getLogger(DemoServiceB.class);

    @Override
    public void displayDemoMessage() {
        logger.info("DemoServiceB display message from B.");
    }
}
