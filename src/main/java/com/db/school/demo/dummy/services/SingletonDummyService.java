package com.db.school.demo.dummy.services;

import org.springframework.stereotype.Service;

@Service
public class SingletonDummyService {
    public SingletonDummyService() {
        System.out.println("SingletonDummyService");
    }
}
