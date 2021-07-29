package com.db.school.demo.dummy.services.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("dev")
@Slf4j
public class DemoServiceA implements DemoService {

    @Override
    public String displayDemoMessage() {
        String message = "DemoServiceA display message.";
        log.info(message);
        return message;
    }
}
