package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Collection;
import com.tedu.blog.pojo.Comment;

public interface CollectionService {
    PageInfo<Collection> selectByCollection(Integer pageNum, Integer pageSize, Collection collection);
    public Integer insert(Collection collection);
}