package com.zxw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxw.dao.OrderMapper;
import com.zxw.entity.VideoOrder;
import com.zxw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void save(VideoOrder videoOrder) {
        orderMapper.save(videoOrder);
    }


}
