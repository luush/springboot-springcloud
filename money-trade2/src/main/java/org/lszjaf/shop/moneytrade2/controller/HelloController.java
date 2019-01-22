package org.lszjaf.shop.moneytrade2.controller;

import org.lszjaf.shop.moneytrade2.common.ResponseDTO;
import org.lszjaf.shop.moneytrade2.common.ReturnCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public ResponseDTO hello(@RequestParam String name) {
        ResponseDTO responseDTO = new ResponseDTO(ReturnCode.REQUEST_SUCCESS);
        responseDTO.setAttach("hi " + name + ",i am from port:" + port);
        return responseDTO;
    }

    @PostMapping("/json")
    public String json(@RequestBody String params){
        return "hi " + params + ",i am from port:" + port;
    }

    @RequestMapping(value = "/inner/trade", method = RequestMethod.GET)
    public ResponseDTO noticeDealtrade(@RequestParam(value = "orderNo") String orderNo){
        System.out.println(orderNo);
        ResponseDTO responseDTO = new ResponseDTO(ReturnCode.REQUEST_SUCCESS);
        responseDTO.setAttach("hi " + orderNo + ",i am from port:" + port);
        return responseDTO;
    }
}
