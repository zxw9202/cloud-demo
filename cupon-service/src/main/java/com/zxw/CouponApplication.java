package com.zxw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.zxw.mapper")
@EnableSwagger2
// 让注册中心能够发现，扫描到该服务
@EnableDiscoveryClient
//开启Feign支持
@EnableFeignClients
// 让注册中心能够发现，扫描到该服务
public class CouponApplication {

    public static void main(String[] args){
        SpringApplication.run(CouponApplication.class,args);
    }

    /**
     * 负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
