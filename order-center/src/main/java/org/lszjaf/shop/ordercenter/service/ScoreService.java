package org.lszjaf.shop.ordercenter.service;

import org.lszjaf.shop.ordercenter.common.ResponseDTO;
import org.lszjaf.shop.ordercenter.service.impl.ScoreServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "score-center", fallback = ScoreServiceImpl.class)
@Component("scoreService")
public interface ScoreService {

//    @RequestMapping(value = "/hi", method = RequestMethod.GET)
//    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @PostMapping(value = "/score")
    ResponseDTO noticeDealScore(@RequestBody String json);

}
