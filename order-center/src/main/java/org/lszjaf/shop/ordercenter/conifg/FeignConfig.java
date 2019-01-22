package org.lszjaf.shop.ordercenter.conifg;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    //该代码更改了该FeignClient的重试次数，重试间隔为100ms，最大重试时间为1s,重试次数为5次。
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,1000,5);
    }
}
