package com.zxw.service;

import com.zxw.entity.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("video-service")
public interface VideoService {

    @GetMapping("/api/v1/video/findById")
    Video findById(@RequestParam("videoId") int videoId);
}