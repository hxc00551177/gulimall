package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.SmsCouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author hanxucheng
 * @email hanxu6517@163.com
 * @date 2021-06-08 14:56:54
 */
@Mapper
public interface SmsCouponDao extends BaseMapper<SmsCouponEntity> {
	
}
