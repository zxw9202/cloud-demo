package com.zxw.controller;

import com.zxw.domain.Video;
import com.zxw.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/video")
@Api(value="视频服务")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("findById")
    @ApiOperation("根据id查询视频信息")
    public Object findById(int videoId, HttpServletRequest request){
        Video video = videoService.findById(videoId);
        video.setServiceInfo(request.getServerName()+":"+request.getServerPort());
        return video;
    }
}
