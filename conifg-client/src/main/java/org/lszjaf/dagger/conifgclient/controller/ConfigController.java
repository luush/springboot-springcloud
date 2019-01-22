package org.lszjaf.dagger.conifgclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${name}")
    String foo;
    @Value("${age}")
    Integer age;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

    @RequestMapping(value = "/age")
    public Integer age(){
        return age;
    }
}
