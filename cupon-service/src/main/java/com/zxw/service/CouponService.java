package com.zxw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.entity.Coupon;

/**
 * <p>
 * 优惠券表 服务类
 * </p>
 *
 * @author 18354
 * @since 2023-04-23
 */
public interface CouponService extends IService<Coupon> {

    boolean save(Coupon coupon);

}
