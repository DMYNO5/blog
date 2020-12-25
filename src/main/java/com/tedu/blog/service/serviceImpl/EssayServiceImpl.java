package com.tedu.blog.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.CommentMapper;
import com.tedu.blog.mapper.CommentMapper2;
import com.tedu.blog.mapper.EssayMapper;
import com.tedu.blog.mapper.EssayPageMapper;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.CommentExample;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.EssayExample;
import com.tedu.blog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class


EssayServiceImpl implements EssayService {

    @Autowired
    EssayPageMapper essayPageMapper;

    @Autowired(required = false)
    EssayMapper essayMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentMapper2 commentMapper2;

    /**
     * 赵飞宇      新增文章的方法
     *
     * @param essay
     * @return
     */
    @Override
    public int insertEssay(Essay essay) {
        Integer essays = essayMapper.insert(essay);

        return essays;
    }

    /**
     * 赵飞宇      通过文章的id删除文章的方法
     *
     * @param essayId
     * @return
     */
    @Override
    public int deleteById(Integer essayId) {

        Integer essays = essayMapper.deleteByPrimaryKey(essayId);

        return essays;
    }

    /**
     * 赵飞宇      更新文章
     *
     * @param essay
     * @return
     */
    @Override
    public int update(Essay essay) {

        Integer essays = essayMapper.updateByPrimaryKeySelective(essay);

        return essays;
    }

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
        if (!StringUtils.isEmpty(essay.getEssayId())) {
            criteria.andEssayIdEqualTo(essay.getEssayId());
        }
        if (!StringUtils.isEmpty(essay.getUserId())) {
            criteria.andUserIdEqualTo(essay.getUserId());
        }
        if (!StringUtils.isEmpty(essay.getTitle())) {
            criteria.andTitleEqualTo(essay.getTitle());
        }
        if (!StringUtils.isEmpty(essay.getImage())) {
            criteria.andImageEqualTo(essay.getImage());
        }
        if (!StringUtils.isEmpty(essay.getContent())) {
            criteria.andContentEqualTo(essay.getContent());
        }
        if (!StringUtils.isEmpty((essay.getPower()))) {
            criteria.andPowerEqualTo(essay.getPower());
        }
        if (!StringUtils.isEmpty(essay.getCategoryId())) {
            criteria.andCategoryIdEqualTo(essay.getCategoryId());
        }
        if (!StringUtils.isEmpty(essay.getcCount())) {
            criteria.andCCountEqualTo(essay.getcCount());
        }
        if (!StringUtils.isEmpty(essay.getCommentCount())) {
            criteria.andCommentCountEqualTo(essay.getCommentCount());
        }
        if (!StringUtils.isEmpty(essay.getWeight())) {
            criteria.andWeightEqualTo(essay.getWeight());
        }
        if (!StringUtils.isEmpty(essay.getCreatedTime())) {
            criteria.andCreatedTimeEqualTo(essay.getCreatedTime());
        }
        if (!StringUtils.isEmpty((essay.getUpdateTime()))) {
            criteria.andUpdateTimeEqualTo(essay.getUpdateTime());
        }

        List<Essay> essayList = essayMapper.selectByExample(essayExample);
        PageInfo pageInfo = new PageInfo(essayList);

        return pageInfo;
    }

    public PageInfo<Essay> selectByPower(Integer pageNum, Integer pageSize, Essay essay) {
        PageHelper.startPage(pageNum, pageSize);
        EssayExample essayExample = new EssayExample();
        EssayExample.Criteria criteria = essayExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        criteria.andPowerIn(list);
        List<Essay> essayList = essayMapper.selectByExample(essayExample);
        PageInfo pageInfo = new PageInfo(essayList);

        return pageInfo;
    }

    //贾旭业。根据essayId查出文章对象
    public Essay selectEssayByEssayId(Integer essayId) {
        Essay essay = essayMapper.selectByPrimaryKey(essayId);
        Date createdTime = essay.getCreatedTime();
        Date updateTime = essay.getUpdateTime();

        return essay;
    }

    //贾旭业。根据essayId查出评论对象的list集合
    public List<Comment> selectCommentsByEssayId(Integer essayId) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.or();
        criteria.andEssayIdEqualTo(essayId);
        List<Comment> ListComment = commentMapper.selectByExample(example);
        return ListComment;
    }

    //贾旭业。根据essayId查出评论对象的list集合//两表联查
    public List<Comment> selectCommentsByEssayId2(Integer essayId) {
        List<Comment> commentList = commentMapper2.selectCommentsByEssayId2(essayId);
        return commentList;
    }

    //贾旭业。向评论表插入一条评论
    public Integer insert(Comment comment) {
        Date date = new Date();
        comment.setCreatedTime(date);
        Integer i = commentMapper.insert(comment);
        return i;
    }

}