package com.db.school.demo.dummy;

import com.db.school.demo.dummy.services.demo.DemoService;
import com.db.school.demo.dummy.services.scope.PrototypeDummyService;
import com.db.school.demo.dummy.services.scope.RequestDummyService;
import com.db.school.demo.dummy.services.scope.SingletonDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {
    private int counter;

    @Value("${service.type}")
    private String type;

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

    @GetMapping("/demo/multiplechoice")
    public String getService(){
        Optional<DemoService> demoServiceOp = demoServiceList.stream().filter(x -> x.getClass().getSimpleName().equals(type)).findFirst();
        if(demoServiceOp.isPresent()){
            return demoServiceOp.get().displayDemoMessage();
        } else {
            return null;
        }
    }


}
