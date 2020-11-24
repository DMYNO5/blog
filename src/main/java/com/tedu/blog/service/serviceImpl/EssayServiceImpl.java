package com.tedu.blog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.EssayMapper;
import com.tedu.blog.mapper.EssayPageMapper;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.EssayExample;
import com.tedu.blog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public PageInfo<Essay> selectByEssay(Integer pageNum, Integer pageSize, Essay essay) {
        PageHelper.startPage(pageNum, pageSize);
        EssayExample essayExample = new EssayExample();
        EssayExample.Criteria criteria = essayExample.createCriteria();
        if(!StringUtils.isEmpty(essay.getEssayId())){
            criteria.andEssayIdEqualTo(essay.getEssayId());
        }
        if(!StringUtils.isEmpty(essay.getUserId())){
            criteria.andUserIdEqualTo(essay.getEssayId());
        }
        if(!StringUtils.isEmpty(essay.getTitle())){
            criteria.andTitleEqualTo(essay.getTitle());
        }
        if(!StringUtils.isEmpty(essay.getImage())){
            criteria.andImageEqualTo(essay.getImage());
        }
        if(!StringUtils.isEmpty(essay.getContent())){
            criteria.andContentEqualTo(essay.getContent());
        }
        if(!StringUtils.isEmpty((essay.getPower()))){
            criteria.andPowerEqualTo(essay.getPower());
        }
        if(!StringUtils.isEmpty(essay.getCategoryId())){
            criteria.andCategoryIdEqualTo(essay.getCategoryId());
        }
        if(!StringUtils.isEmpty(essay.getcCount())){
            criteria.andCCountEqualTo(essay.getcCount());
        }
        if (!StringUtils.isEmpty(essay.getCommentCount())){
            criteria.andCommentCountEqualTo(essay.getCommentCount());
        }
        if (!StringUtils.isEmpty(essay.getWeight())){
            criteria.andWeightEqualTo(essay.getWeight());
        }
        if(!StringUtils.isEmpty(essay.getCreatedTime())){
            criteria.andCreatedTimeEqualTo(essay.getCreatedTime());
        }
        if(!StringUtils.isEmpty((essay.getUpdateTime()))){
            criteria.andUpdateTimeEqualTo(essay.getUpdateTime());
        }

        List<Essay> essayList = essayMapper.selectByExample(essayExample);
        PageInfo pageInfo = new PageInfo(essayList);

        return pageInfo;
    }
}