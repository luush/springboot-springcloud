package org.lszjaf.dagger.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    /**
     * git远程厂库根目录下面有一个config-test.yml的文件
     * http获取远程文件的集中方式：
     * /filename
     * /branch/filename
     *
     *
     * http://localhost:8089/master/config-test.yml
     * master:git 厂库的分支
     * config-test.yml:git 厂库的文件名
     *
     * http://localhost:8089/config-test.yml
     *
     * http://localhost:8089/config/test
     *
     * http://localhost:8089/config/test/master
     */
}

