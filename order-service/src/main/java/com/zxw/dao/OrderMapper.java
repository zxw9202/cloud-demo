package com.zxw.dao;

import com.zxw.domain.VideoOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {


    void save(VideoOrder videoOder);
}
