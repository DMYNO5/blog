package com.tedu.blog.service.serviceImpl;

import com.tedu.blog.mapper.CategoryMapper;
import com.tedu.blog.pojo.Category;
import com.tedu.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    //贾旭业//查出所有category
    @Override
    public List<Category> selectAll() {
        List<Category> categories = categoryMapper.selectByExample(null);
        return categories;
    }
}
