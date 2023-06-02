package com.zxw.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxw.entity.Coupon;
import com.zxw.mapper.CouponMapper;
import com.zxw.service.CouponService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.geom.AreaOp;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * <p>
 * 优惠券表 服务实现类
 * </p>
 *
 * @author 18354
 * @since 2023-04-23
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public boolean save(Coupon coupon) {
        boolean result = false;
        if(ObjectUtils.isNotEmpty(coupon)) {
            coupon.setActive("1");
            coupon.setCreateTime(new Date());
            couponMapper.insert(coupon);
            result =  true;
        }
        return result;
    }
}
