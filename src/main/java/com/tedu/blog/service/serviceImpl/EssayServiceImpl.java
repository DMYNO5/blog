package com.tedu.blog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.EssayMapper;
import com.tedu.blog.mapper.EssayPageMapper;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    EssayPageMapper essayPageMapper;

    @Autowired(required = false)
    EssayMapper essayMapper;

    @Override
    public PageInfo<Essay> selectPage(Integer pageNum, Integer pageSize) {
        String orderBy = "created_time desc";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Essay> essayList = essayPageMapper.selectPage();
        PageInfo pageInfo = new PageInfo(essayList);
        return pageInfo;
    }

    @Override
    public PageInfo<Essay> selectByTitle(Integer pageNum, Integer pageSize, Essay essay) {
        String orderBy = "created_time desc";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Essay> essayList = essayPageMapper.selectByTitle(essay);
        PageInfo pageInfo = new PageInfo(essayList);
        return pageInfo;
    }
}