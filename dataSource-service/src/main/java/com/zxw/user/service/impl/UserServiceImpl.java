package com.zxw.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxw.dataSource.DataSource;
import com.zxw.dataSource.DataSourceType;
import com.zxw.user.dto.UserDto;
import com.zxw.user.entity.User;
import com.zxw.user.entity.Video;
import com.zxw.user.mapper.DataSourceMapper;
import com.zxw.user.service.UserService;
import com.zxw.utils.PageUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxw
 * @since 2023-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<DataSourceMapper, User> implements UserService {

    @Autowired
    private DataSourceMapper userMapper;



    @DataSource(value = DataSourceType.USERDB)
    @Override
    public List<User> queryUserList() {
        return userMapper.selectList(new QueryWrapper<User>());
    }

    @DataSource(value = DataSourceType.VIDEODB)
    @Override
    public List<Video> queryVideoList() {
        return userMapper.queryVideoList();
    }

    @DataSource(value = DataSourceType.BASE)
    @Override
    public List<User> queryBaseUserList() {
        return userMapper.queryBaseUserList();
    }


}
