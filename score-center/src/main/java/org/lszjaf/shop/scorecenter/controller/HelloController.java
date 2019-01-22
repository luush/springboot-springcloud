package org.lszjaf.shop.scorecenter.controller;

import org.lszjaf.shop.scorecenter.common.ResponseDTO;
import org.lszjaf.shop.scorecenter.common.ReturnCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hello(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    @PostMapping("/json")
    public String json(@RequestBody String params){
        return "hi " + params + ",i am from port:" + port;
    }

    @PostMapping(value = "/score")
    ResponseDTO noticeDealScore(@RequestBody String json){
        System.out.println(json);
        ResponseDTO responseDTO = new ResponseDTO(ReturnCode.REQUEST_SUCCESS);
        responseDTO.setAttach("hi " + json + ",i am from port:" + port);
        return responseDTO;
    }
}
