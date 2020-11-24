package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Dataanalysis;
import com.tedu.blog.pojo.DataanalysisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DataanalysisMapper {
    long countByExample(DataanalysisExample example);

    int deleteByExample(DataanalysisExample example);

    int deleteByPrimaryKey(Integer dataId);

    int insert(Dataanalysis record);

    int insertSelective(Dataanalysis record);

    List<Dataanalysis> selectByExample(DataanalysisExample example);

    Dataanalysis selectByPrimaryKey(Integer dataId);

    int updateByExampleSelective(@Param("record") Dataanalysis record, @Param("example") DataanalysisExample example);

    int updateByExample(@Param("record") Dataanalysis record, @Param("example") DataanalysisExample example);

    int updateByPrimaryKeySelective(Dataanalysis record);

    int updateByPrimaryKey(Dataanalysis record);
}