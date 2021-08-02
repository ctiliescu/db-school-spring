package com.db.shopify.dummy.services.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class PrototypeDummyService {
    @Value("${spring.datasource.password}")
    private String valueFromPropertiesFile;

    public PrototypeDummyService() {
        System.out.println("PrototypeDummyService");
    }
    public void test(){
        System.out.println("proto ---> " + valueFromPropertiesFile);
    }
}
