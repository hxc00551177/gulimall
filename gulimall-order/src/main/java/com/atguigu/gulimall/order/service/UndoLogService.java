package com.atguigu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author hanxucheng
 * @email hanxu6517@163.com
 * @date 2021-06-08 14:43:51
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

