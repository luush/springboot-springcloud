package org.lszjaf.shop.servicezuul.connfig;

import org.lszjaf.shop.servicezuul.filters.ErrorFilter;
import org.lszjaf.shop.servicezuul.filters.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
    @Bean
    public MyFilter throwExceptionFilter() {
        return new MyFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
