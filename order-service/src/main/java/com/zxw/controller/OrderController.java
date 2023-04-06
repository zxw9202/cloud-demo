package com.zxw.controller;

import com.zxw.domain.Video;
import com.zxw.domain.VideoOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@Api(value="订单服务")
@Slf4j
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/save")
    @ApiOperation("保存视频订单")
    public Object save(int videoId){
        List<ServiceInstance> list = discoveryClient.getInstances("video-service");
        ServiceInstance serviceInstance = list.get(0);
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+
                "/api/v1/video/findById?videoId="+videoId;
        log.info("url:【{}】",url);
        Video video = restTemplate.getForObject(url, Video.class);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());

        return videoOrder;
    }
}
