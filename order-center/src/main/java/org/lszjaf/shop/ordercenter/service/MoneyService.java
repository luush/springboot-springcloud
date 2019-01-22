package org.lszjaf.shop.ordercenter.service;

import org.lszjaf.shop.ordercenter.common.ResponseDTO;
import org.lszjaf.shop.ordercenter.service.impl.MoneyServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient( value = "money-trade" ,fallback = MoneyServiceImpl.class)
@Component("moneyService")
public interface MoneyService {

    @RequestMapping(value = "/inner/trade", method = RequestMethod.GET)
    ResponseDTO noticeDealtrade(@RequestParam(value = "orderNo") String orderNo);
}
