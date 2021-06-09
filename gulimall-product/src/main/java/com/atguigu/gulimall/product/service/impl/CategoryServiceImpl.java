package com.atguigu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryCategoryTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> collect = categoryEntities.stream().filter(a -> a.getParentCid() == 0).map(a -> {
            a.setCategoryEntityList(getCategoryChild(a, categoryEntities));
            return a;
        }).sorted((a, b) -> (b.getSort() == null ? 0 : b.getSort()) - (a.getSort() == null ? 0 : a.getSort())).collect(Collectors.toList());
        return collect;
    }

    private List<CategoryEntity> getCategoryChild(CategoryEntity categoryEntity, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> collect = categoryEntities.stream().filter(a -> a.getParentCid() == categoryEntity.getCatId()).map(a -> {
            a.setCategoryEntityList(getCategoryChild(a, categoryEntities));
            return a;
        }).sorted((a, b) -> (b.getSort() == null ? 0 : b.getSort()) - (a.getSort() == null ? 0 : a.getSort())).collect(Collectors.toList());
        return collect;
    }

}