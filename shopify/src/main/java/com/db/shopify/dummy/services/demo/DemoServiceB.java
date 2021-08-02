package com.db.shopify.dummy.services.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("DemoB")
@Slf4j
public class DemoServiceB implements DemoService {
    @Override
    public String displayDemoMessage() {
        String message = "DemoServiceB display message from B.";
        log.info(message);
        return message;
    }
}
