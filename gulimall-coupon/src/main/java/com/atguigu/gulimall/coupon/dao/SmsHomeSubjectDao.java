package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.SmsHomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author hanxucheng
 * @email hanxu6517@163.com
 * @date 2021-06-08 14:56:53
 */
@Mapper
public interface SmsHomeSubjectDao extends BaseMapper<SmsHomeSubjectEntity> {
	
}
