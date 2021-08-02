package com.db.shopify.dummy.services.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestDummyService {
    public RequestDummyService() {
        System.out.println("RequestDummyService");
    }
    public void test(){
        System.out.println("ceva");
    }
}
