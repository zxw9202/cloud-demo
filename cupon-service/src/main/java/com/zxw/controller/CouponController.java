package com.zxw.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.dto.CouponDto;
import com.zxw.entity.Coupon;
import com.zxw.entity.Video;
import com.zxw.service.CouponService;
import com.zxw.service.UserService;
import com.zxw.user.entity.User;
import com.zxw.utils.AjaxResult;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zxw.utils.AjaxResult.error;
import static com.zxw.utils.AjaxResult.ok;

@RestController
@RequestMapping("coupon")
@Api(value="优惠券服务")
@Slf4j
public class CouponController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private UserService userService;

    /**
     * 测试分布式事务 回滚
     * @param
     * @return
     */
    @ApiOperation("新增")
    @PostMapping("/insert")
//    @GlobalTransactional
    public AjaxResult<Boolean> insert(@RequestBody CouponDto dto){
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(dto,coupon);
        User user = new User();
        user.setUsername(dto.getUsername());
        couponService.save(coupon);
        int a=3;
        int b=0;
        b= 3/0;
        //Feign 远程调用
        if(userService.insert(user)){
            return ok("新增成功");
        }else{
            return error("新增异常，请检查数据！");
        }
    }



    /**
     * 分页查询列表
     * @param entity
     * @return
     */
    @ApiOperation(value = "查询列表", notes = "查询列表-分页")
    @GetMapping("/queryPage")
    public AjaxResult<List<Coupon>> queryPage(Coupon entity){
        return ok(couponService.list(new LambdaQueryWrapper<>()));

    }
}
