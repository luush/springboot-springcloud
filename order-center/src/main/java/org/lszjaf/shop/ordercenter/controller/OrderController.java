package org.lszjaf.shop.ordercenter.controller;

import com.alibaba.fastjson.JSONObject;
import org.lszjaf.shop.ordercenter.common.ResponseDTO;
import org.lszjaf.shop.ordercenter.service.DeliverService;
import org.lszjaf.shop.ordercenter.service.MoneyService;
import org.lszjaf.shop.ordercenter.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private DeliverService deliverService;
    @Autowired
    private MoneyService moneyService;
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/hii", method = RequestMethod.GET)
    public ResponseDTO order(@RequestParam String name) {
        //下单信息
        System.out.println("下单信息" + name);
        //通知发单deliver-order
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "luush");
        jsonObject.put("age", 18);
        jsonObject.put("address", "beijing");
        ResponseDTO re = deliverService.noticeDeliver(jsonObject.toJSONString());
        //金额划扣money-trade

        ResponseDTO re2 = moneyService.noticeDealtrade("122333321321321xxx");
        //积分处理score-center
        ResponseDTO re3 = scoreService.noticeDealScore(jsonObject.toJSONString());
        ResponseDTO responseDTO = new ResponseDTO();
        if (re.getCode() == 200 && re2.getCode() == 200 && re3.getCode() == 200) {
            responseDTO.setCode(200);
        } else {
            responseDTO.setCode(400);
        }
        responseDTO.setAttach(re.getAttach().toString() + re2.getAttach() + re3.getAttach());
        return responseDTO;
    }

    @GetMapping(value = "/testjson")
    public String testJsonPost() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "luush");
        jsonObject.put("age", 18);
        jsonObject.put("address", "beijing");
        return "";
    }


}
