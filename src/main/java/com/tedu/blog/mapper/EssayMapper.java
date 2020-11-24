package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.EssayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EssayMapper {
    long countByExample(EssayExample example);

    int deleteByExample(EssayExample example);

    int deleteByPrimaryKey(Integer essayId);

    int insert(Essay record);

    int insertSelective(Essay record);

    List<Essay> selectByExample(EssayExample example);

    Essay selectByPrimaryKey(Integer essayId);

    int updateByExampleSelective(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByExample(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);
}