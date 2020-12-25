package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Label;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LabelToIdAndDescribedMapper {
    List<Label> selectToId(Integer labelId);

    List<Label> selectToDescribed();

}
