package org.lszjaf.shop.deliverorder.controller;

import org.lszjaf.shop.deliverorder.common.ResponseDTO;
import org.lszjaf.shop.deliverorder.common.ReturnCode;
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

    @PostMapping(value = "/notice")
    ResponseDTO noticeDeliver(@RequestBody String json){
        System.out.println(json);
        ResponseDTO responseDTO = new ResponseDTO(ReturnCode.REQUEST_SUCCESS);
        responseDTO.setAttach("hi " + json + ",i am from port:" + port);
        return responseDTO;
    }
}
