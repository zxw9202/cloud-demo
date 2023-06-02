package com.zxw.controller;

import com.zxw.entity.Video;
import com.zxw.entity.VideoOrder;
import com.zxw.service.OrderService;
import com.zxw.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
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
    private VideoService videoService;


    @Autowired
    private OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/save")
    @ApiOperation("保存视频订单")
    public Object save(int videoId){
//        List<ServiceInstance> list = discoveryClient.getInstances("video-service");
//        ServiceInstance serviceInstance = list.get(0);
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+
//                "/api/v1/video/findById?videoId="+videoId;
        //远程服务调用
//        String url = "http://video-service/api/v1/video/findById?videoId="+videoId;
//        log.info("url:【{}】",url);
//        Video video = restTemplate.getForObject(url, Video.class);
        //Feign 远程调用
        Video video = videoService.findById(videoId);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());
        videoOrder.setServiceInfo(video.getServiceInfo());
        return videoOrder;
    }



}
