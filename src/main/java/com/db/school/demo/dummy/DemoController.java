package com.db.school.demo.dummy;

import com.db.school.demo.dummy.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
//    @Autowired
//    private DemoService demoService;
    @Autowired
    List<DemoService> demoServiceList;

    @GetMapping("/demo")
    public String getCustomer(@RequestParam("name") String name){
        counter++;
        requestDummyService.test();
        prototypeDummyService.test();
        demoServiceList.forEach(DemoService::displayDemoMessage);

        return "Data about customer " + name + " - " + counter;
    }
}
