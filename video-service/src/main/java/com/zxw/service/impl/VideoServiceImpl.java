package com.zxw.service.impl;

import com.zxw.dao.VideoMapper;
import com.zxw.domain.Video;
import com.zxw.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findById(int videoId) {
        return videoMapper.findById(videoId);
    }
}
