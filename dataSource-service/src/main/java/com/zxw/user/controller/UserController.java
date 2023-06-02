package com.zxw.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.user.dto.UserDto;
import com.zxw.user.entity.User;
import com.zxw.user.entity.Video;
import com.zxw.user.service.UserService;
import com.zxw.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.zxw.utils.AjaxResult.error;
import static com.zxw.utils.AjaxResult.ok;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 18354
 * @since 2023-04-14
 */
@RestController
@RequestMapping("api/v1/data")
@Api(value="订单服务")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;





    @GetMapping("users")
    public List<User> showUser(){
        return service.queryUserList();
    }

    @GetMapping("videos")
    public List<Video> showVideo(){
        return service.queryVideoList();
    }

//    @GetMapping("base/users")
//    public List<User> showbaseUsers(){
//        return service.queryBaseUserList();
//    }



}

