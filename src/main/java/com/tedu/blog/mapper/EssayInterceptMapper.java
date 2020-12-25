package com.tedu.blog.mapper;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Essay;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EssayInterceptMapper {
    List<Essay> essayIntercept();

}
