package org.lszjaf.shop.ordercenter.service;

import org.lszjaf.shop.ordercenter.common.ResponseDTO;
import org.lszjaf.shop.ordercenter.service.impl.DeliverServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//fallback将指定  熔断类
@FeignClient(value = "deliver-order", fallback = DeliverServiceImpl.class)
@Component("deliverService")
public interface DeliverService {

//    @RequestMapping(value = "/notice", method = RequestMethod.GET)
//    String noticeDeliver(@RequestParam(value = "name") String name);

    @PostMapping(value = "/notice")
    ResponseDTO noticeDeliver(@RequestBody String json);

}
