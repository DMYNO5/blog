package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Category;

public interface CategoryService {
    int insertCategory(Category category);

    int updateCategory(Category category);

    int deleteById(Integer CategoryId);

    PageInfo<Category> listAllCategory(Integer pageNum, Integer pageSize);

    PageInfo<Category> selectByCategory(Category category, Integer pageNum, Integer pageSize);
}
