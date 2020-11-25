package com.tedu.blog.controller;

import com.tedu.blog.pojo.Category;
import com.tedu.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //贾旭业/查出所有category
    @RequestMapping("/sellectAll")
    public List<Category> sellectAll(){
        List<Category> categories = categoryService.selectAll();
        return categories;
    }
}
