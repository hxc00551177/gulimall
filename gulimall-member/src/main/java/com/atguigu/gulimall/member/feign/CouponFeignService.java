package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author Han XuCheng
 * @create 2021-06-08-17:26
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/smscoupon/listCoupon")
    R listCoupon();

}
