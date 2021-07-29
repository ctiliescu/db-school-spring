package com.db.school.demo.dummy.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeDummyService {
    public PrototypeDummyService() {
        System.out.println("PrototypeDummyService");
    }
    public void test(){
        System.out.println("proto");
    }
}
