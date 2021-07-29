package com.db.school.demo.dummy;

import com.db.school.demo.dummy.services.PrototypeDummyService;
import com.db.school.demo.dummy.services.RequestDummyService;
import com.db.school.demo.dummy.services.SingletonDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private int counter;
    public DemoController() {
        System.out.println("----------------> DemoController was created! <--------------------");
    }
    @Autowired
    private SingletonDummyService singletonDummyService;
    @Autowired
    private RequestDummyService requestDummyService;
    @Autowired
    private PrototypeDummyService prototypeDummyService;

    @GetMapping("/demo")
    public String getCustomer(@RequestParam("name") String name){
        counter++;
        requestDummyService.test();
        prototypeDummyService.test();
        return "Data about customer " + name + " - " + counter;
    }
}
