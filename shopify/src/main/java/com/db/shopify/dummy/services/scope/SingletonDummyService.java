package com.db.shopify.dummy.services.scope;

import org.springframework.stereotype.Service;

@Service
public class SingletonDummyService {
    public SingletonDummyService() {
        System.out.println("SingletonDummyService");
    }
}
