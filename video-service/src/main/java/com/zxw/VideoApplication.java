package com.zxw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.zxw.dao")
@EnableSwagger2
@EnableDiscoveryClient
public class VideoApplication {

    public static void main(String[] args){
        SpringApplication.run(VideoApplication.class,args);
    }
}
