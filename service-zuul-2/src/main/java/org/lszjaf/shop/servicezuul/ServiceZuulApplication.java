package org.lszjaf.shop.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 注意:
 * 开启重试在某些情况下是有问题的，比如当压力过大，一个实例停止响应时，路由将流量转到另一个实例，
 * 很有可能导致最终所有的实例全被压垮。说到底，断路器的其中一个作用就是防止故障或者压力扩散。
 * 用了retry，断路器就只有在该服务的所有实例都无法运作的情况下才能起作用。这种时候，
 * 断路器的形式更像是提供一种友好的错误信息，或者假装服务正常运行的假象给使用者。
 * 不用retry，仅使用负载均衡和熔断，就必须考虑到是否能够接受单个服务实例关闭和
 * eureka刷新服务列表之间带来的短时间的熔断。如果可以接受，就无需使用retry。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableAutoConfiguration
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }


}

