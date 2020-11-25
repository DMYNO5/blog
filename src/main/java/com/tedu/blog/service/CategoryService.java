package com.tedu.blog.service;

import com.tedu.blog.pojo.Category;
import java.util.List;
import com.github.pagehelper.PageInfo;

public interface CategoryService {
    public List<Category> selectAll();

    int insertCategory(Category category);

    int updateCategory(Category category);

    int deleteById(Integer CategoryId);

    PageInfo<Category> listAllCategory(Integer pageNum, Integer pageSize);

    PageInfo<Category> selectByCategory(Category category, Integer pageNum, Integer pageSize);

}
