package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Essay;

public interface EssayService {
    PageInfo<Essay> selectPage(Integer pageNum, Integer pageSize);

    PageInfo<Essay> selectByTitle(Integer pageNum, Integer pageSize, Essay essay);

    PageInfo<Essay> selectByEssay(Integer pageNum, Integer pageSize, Essay essay);


    int insertEssay( Essay essay);

}
