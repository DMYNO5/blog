package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Label;
import org.apache.ibatis.annotations.Insert;

public interface LabelService {
     int insertLabel(Label label);

    int updateLabel(Label label);

    int deleteById(Integer LabelId);

    PageInfo<Label> listAllLabel(Integer pageNum, Integer pageSize);

    PageInfo<Label> selectByLabel(Label label,Integer pageNum,Integer pageSize);


}
