package com.tedu.blog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.LabelMapper;
import com.tedu.blog.pojo.Label;
import com.tedu.blog.pojo.LabelExample;

import com.tedu.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service
public class LabelServiceImpl implements LabelService {
    @Autowired(required = false)
    LabelMapper labelMapper;


    //添加
    public int insertLabel(Label label) {
        label.setCreatedTime(new Date());
        int row = labelMapper.insertSelective(label);
        return row;
    }

    //修改
    public int updateLabel(Label label) {
        label.setUpdateTime(new Date());
        int row = labelMapper.updateByPrimaryKeySelective(label);
        return row;
    }

    //删除
    public int deleteById(Integer id) {
        int row = labelMapper.deleteByPrimaryKey(id);
        return row;
    }


    //查找全部
    public PageInfo<Label> listAllLabel(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Label> labelList = labelMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(labelList);
        return pageInfo;
    }

    //根据label查询label
    public PageInfo<Label> selectByLabel(Label label, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        LabelExample labelExample = new LabelExample();
        LabelExample.Criteria criteria = labelExample.createCriteria();
        if (!StringUtils.isEmpty(label.getLabelId())) {
            criteria.andLabelIdEqualTo(label.getLabelId());
        } else if (!StringUtils.isEmpty(label.getEssayId())) {
            criteria.andEssayIdEqualTo(label.getEssayId());
        } else if (!StringUtils.isEmpty(label.getDescribed())) {
            criteria.andDescribedEqualTo(label.getDescribed());
        }
        List<Label> labelList = labelMapper.selectByExample(labelExample);
        PageInfo pageInfo = new PageInfo(labelList);
        return pageInfo;
    }

    //根据描述查找label
    public PageInfo<Label> selectByDescribed(String described, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        LabelExample labelExample = new LabelExample();
        LabelExample.Criteria criteria = labelExample.or();
        criteria.andDescribedEqualTo(described);
        List<Label> labelList = labelMapper.selectByExample(labelExample);
        PageInfo pageInfo = new PageInfo(labelList);
        return pageInfo;
    }


}
