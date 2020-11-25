package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Category;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.Label;

import java.util.List;

public interface EssayService {
    PageInfo<Essay> selectPage(Integer pageNum, Integer pageSize);

    PageInfo<Essay> selectByTitle(Integer pageNum, Integer pageSize, Essay essay);

    PageInfo<Essay> selectByEssay(Integer pageNum, Integer pageSize, Essay essay);



    int insertEssay( Essay essay,Label label);

    int deleteById(Integer essayId);

    int update(Essay essay);

    List<Category> selelctcategoryByEssayId(Integer essayId);

    List<Label> selectLabelByEssayId(Integer essayId);

    public Essay selectEssayByEssayId(Integer essayId);

    public List<Comment> selectCommentsByEssayId(Integer essayId);
    public List<Comment> selectCommentsByEssayId2(Integer essayId);
    public Integer insert(Comment comment);

}
