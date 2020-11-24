package com.tedu.blog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.CategoryMapper;
import com.tedu.blog.pojo.Category;
import com.tedu.blog.pojo.CategoryExample;
import com.tedu.blog.pojo.Label;
import com.tedu.blog.pojo.LabelExample;
import com.tedu.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    CategoryMapper categoryMapper;

    //添加
    public int insertCategory(Category category) {
        category.setCreatedTime(new Date());
        int row = categoryMapper.insertSelective(category);
        return row;
    }

    //修改
    public int updateCategory(Category category) {
        category.setUpdateTime(new Date());
        int row = categoryMapper.updateByPrimaryKeySelective(category);
        return row;
    }

    //删除
    public int deleteById(Integer CategoryId) {
        int row = categoryMapper.deleteByPrimaryKey(CategoryId);
        return row;
    }


    //查找全部
    public PageInfo<Category> listAllCategory(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList = categoryMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(categoryList);
        return pageInfo;
    }

    //根据category查找category
    public PageInfo<Category> selectByCategory(Category category, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        if (!StringUtils.isEmpty(category.getCategoryId())) {
            criteria.andCategoryIdEqualTo(category.getCategoryId());
        } else if (!StringUtils.isEmpty(category.getDescribed())) {
            criteria.andDescribedEqualTo(category.getDescribed());
        }
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        PageInfo pageInfo = new PageInfo(categoryList);
        return pageInfo;
    }


}
