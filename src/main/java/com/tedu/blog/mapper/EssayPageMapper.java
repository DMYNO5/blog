package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Essay;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EssayPageMapper {
    List<Essay> selectPage();

    List<Essay> selectByTitle(Essay essay);
}
