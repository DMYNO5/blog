package com.tedu.blog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.CollectionMapper;
import com.tedu.blog.pojo.Collection;
import com.tedu.blog.pojo.CollectionExample;
import com.tedu.blog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public PageInfo<Collection> selectByCollection(Integer pageNum, Integer pageSize, Collection collection) {
        PageHelper.startPage(pageNum, pageSize);
        CollectionExample collectionExample = new CollectionExample();
        CollectionExample.Criteria criteria = collectionExample.createCriteria();
        if (!StringUtils.isEmpty(collection.getColId())) {
            criteria.andColIdEqualTo(collection.getColId());
        }
        if (!StringUtils.isEmpty(collection.getUserId())) {
            criteria.andUserIdEqualTo(collection.getUserId());
        }
        if (!StringUtils.isEmpty(collection.getEssayId())) {
            criteria.andEssayIdEqualTo(collection.getEssayId());
        }
        List<Collection> collectionList = collectionMapper.selectByExample(collectionExample);
        PageInfo pageInfo = new PageInfo(collectionList);
        return pageInfo;
    }

    //贾
    @Override
    public Integer insert(Collection collection) {
        Integer i = collectionMapper.insert(collection);
        return i;
    }

    @Override
    public int deleteByColId(Integer colId) {
        int row = collectionMapper.deleteByPrimaryKey(colId);
        return row;
    }


}
