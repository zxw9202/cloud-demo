package com.zxw.controller;

import com.zxw.domain.Video;
import com.zxw.domain.VideoOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("api/v1/order")
@Api(value="订单服务")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/save")
    @ApiOperation("保存视频订单")
    public Object save(int videoId){
        Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/findById?videoId="+videoId, Video.class);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());

        return videoOrder;
    }
}
