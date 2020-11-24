package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.Essay;

import java.util.List;

public interface EssayService {
    PageInfo<Essay> selectPage(Integer pageNum, Integer pageSize);

    PageInfo<Essay> selectByTitle(Integer pageNum, Integer pageSize, Essay essay);

    PageInfo<Essay> selectByEssay(Integer pageNum, Integer pageSize, Essay essay);

    public Essay selectEssayByEssayId(Integer essayId);
    public List<Comment> selectCommentsByEssayId(Integer essayId);
    public List<Comment> selectCommentsByEssayId2(Integer essayId);
    public Integer insert(Comment comment);
}
