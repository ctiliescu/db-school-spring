package com.db.shopify.dummy;

import com.db.shopify.dummy.services.demo.DemoService;
import com.db.shopify.dummy.services.scope.PrototypeDummyService;
import com.db.shopify.dummy.services.scope.RequestDummyService;
import com.db.shopify.dummy.services.scope.SingletonDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Value("${spring.profiles.active}")
    private String profile;

    public DemoController() {
        System.out.println("----------------> DemoController was created! <--------------------");
    }

    @Autowired
    private SingletonDummyService singletonDummyService;
    @Autowired
    private RequestDummyService requestDummyService;
    @Autowired
    private PrototypeDummyService prototypeDummyService;
    @Autowired
    @Qualifier("DemoB")
    private DemoService demoService;
    @Autowired
    List<DemoService> demoServiceList;

    @GetMapping("/com/db/shopify")
    public String getCustomer(@RequestParam("name") String name){
        counter++;
        requestDummyService.test();
        prototypeDummyService.test();
        demoServiceList.forEach(DemoService::displayDemoMessage);

        return "Data about customer " + name + " - " + counter;
    }

    @GetMapping("/com/db/shopify/multiplechoice")
    public String getService(){
        Optional<DemoService> demoServiceOp = demoServiceList.stream().filter(x -> x.getClass().getSimpleName().equals(type)).findFirst();
        return demoServiceOp.map(DemoService::displayDemoMessage).orElse(profile);
        /*if(demoServiceOp.isPresent()){
            return demoServiceOp.get().displayDemoMessage();
        } else {
            return "not found message";
        }*/
    }

    @GetMapping("/com/db/shopify/qualifier")
    public String getDemoQualifier() {
        return demoService.displayDemoMessage();
    }


}
