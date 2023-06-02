package com.zxw.service;

import com.zxw.user.entity.User;
import com.zxw.utils.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface UserService {

    @GetMapping("/api/v1/user/insert")
    boolean insert(@RequestBody User entity) ;
}