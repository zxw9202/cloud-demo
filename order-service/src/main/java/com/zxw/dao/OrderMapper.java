package com.zxw.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxw.entity.VideoOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {


    void save(VideoOrder videoOder);

}
