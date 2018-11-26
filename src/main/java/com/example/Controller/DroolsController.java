package com.example.Controller;

import com.example.drools.AddressCheckResult;
import com.example.entity.Address;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DroolsController {

    @Resource
    private KieSession kieSession;

    @GetMapping("/address")
    public void test(){
        Address address = new Address();
        address.setPostcode("99431");
        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFireCount = kieSession.fireAllRules();
        System.out.println("触发了"+ruleFireCount + "条规则");
        if(result.isPostCodeResult()){
            System.out.println("规则校验通过");
        }
    }
}
