package com.tedu.blog.controller;


import com.tedu.blog.pojo.Category;
import com.tedu.blog.service.CategoryService;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.Result;
import com.tedu.blog.service.serviceImpl.CategoryServiceImpl;
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

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    //贾旭业/查出所有category
    @RequestMapping("/sellectAll")
    public List<Category> sellectAll() {
        List<Category> categories = categoryService.selectAll();
        return categories;
    }
    //添加分类
    @RequestMapping("/insertCategory")
    public Result insertCategory(Category category) {
        int row = categoryServiceImpl.insertCategory(category);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "添加失败");
    }

    //查看全部分类
    @RequestMapping("/listAllCategory")
    public PageResult ListAllCategory(Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = categoryServiceImpl.listAllCategory(pageNum, pageSize);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    //修改分类
    @RequestMapping("/updateCategory")
    public Result updateCategory(Category category) {
        int row = categoryServiceImpl.updateCategory(category);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "修改失败");
    }

    //删除分类
    @RequestMapping("/deleteById")
    public Result deleteById(Integer categoryId) {
        int row = categoryServiceImpl.deleteById(categoryId);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "删除失败");
    }

    //根据分类查找分类
    @RequestMapping("/selectByCategory")
    public PageResult selectByCategory(Category category, Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = categoryServiceImpl.selectByCategory(category, pageNum, pageSize);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }
}
